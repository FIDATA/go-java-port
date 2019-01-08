package go.path;

import static go.Builtin.*;
import static go.Conversions.*;
import static go.Runtime.GoOS.*;
import com.google.common.collect.ImmutableList;
import go.Conversions;
import go.Os;
import go.Sort;
import go.Strings;
import go.strings.Utf8;
import go.Runtime;
import org.immutables.value.Value;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public final class FilePath {
  public static final char SEPARATOR = Os.PATH_SEPARATOR;

  /**
   * A lazybuf is a lazily constructed path buffer.
   * It supports append, reading previously appended bytes,
   * and retrieving the final string. It does not allocate a buffer
   * to hold the output until that output diverges from s.
   */
  // TOTHINK: Javafy: add getAt, Iterable, toString ?
  private static class Lazybuf {
    private final int pathLen; // without volLen
    private char[] buf = null;
    public int w; // low, without volLen
    private final String volAndPath;
    private final int volLen;

    public Lazybuf(String volAndPath, int volLen) {
      this.volAndPath = volAndPath;
      this.volLen = volLen;
      pathLen = len(volAndPath) - volLen;
      w = 0;
    }

    private char pathChar(int i) {
      return volAndPath.charAt(volLen + i);
    }

    public char index(int i) {
      if (buf != null) {
        return buf[i];
      }
      return pathChar(i);
    }

    public void append(char c) {
      if (buf == null) {
        if (w < pathLen && pathChar(w) == c) {
          w++;
          return;
        }
        buf = makechars(pathLen);
        copy(buf, volAndPath, volLen, volLen + w);
      }
      buf[w] = c;
      w++;
    }

    public String string() {
      if (buf == null) {
        return volAndPath.substring(0, volLen + w);
      }
      // return volAndPath.substring(0, volLen) + string(buf, 0, w);
      char[] result = makechars(volLen + w);
      copy(result, volAndPath, 0, volLen);
      copy(result, volLen, buf, 0, w);
      return Conversions.string(result);
    }
  }

  /**
   * Clean returns the shortest path name equivalent to path
   * by purely lexical processing. It applies the following rules
   * iteratively until no further processing can be done:
   *
   *	1. Replace multiple Separator elements with a single one.
   *	2. Eliminate each . path name element (the current directory).
   *	3. Eliminate each inner .. path name element (the parent directory)
   *	   along with the non-.. element that precedes it.
   *	4. Eliminate .. elements that begin a rooted path:
   *	   that is, replace "/.." by "/" at the beginning of a path,
   *	   assuming Separator is '/'.
   *
   * The returned path ends in a slash only if it represents a root directory,
   * such as "/" on Unix or `C:\` on Windows.
   *
   * Finally, any occurrences of slash are replaced by Separator.
   *
   * If the result of this process is an empty string, Clean
   * returns the string ".".
   *
   * See also Rob Pike, ``Lexical File Names in Plan 9 or
   * Getting Dot-Dot Right,''
   * https://9p.io/sys/doc/lexnames.html
   */
  // DONE
  public static String clean(final String path) {
    final int volLen = volumeNameLen(path);
    int r = volLen; // pathLow
    final int n = len(path); // pathLen
    if (r >= n) {
      if (volLen > 1 && path.charAt(1) != ':') {
        // should be UNC
        return fromSlash(path);
      }
      return path + ".";
    }
    final boolean rooted = Os.isPathSeparator(path.charAt(r));

    // Invariants:
    //	reading from path; r is index of next char to process.
    //	writing to buf; w is index of next byte to write.
    //	dotdot is index in buf where .. must stop, either because
    //		it is the leading slash or it is a leading ../../.. prefix.
    final Lazybuf out = new Lazybuf(path, volLen);
    int dotdot;
    if (rooted) {
      out.append(SEPARATOR);
      r++;
      dotdot = 1;
    } else {
      dotdot = 0;
    }

    while (r < n) {
      if (Os.isPathSeparator(path.charAt(r))) {
        // empty path element
        r++;
      } else if (path.charAt(r) == '.' && (r + 1 == n || Os.isPathSeparator(path.charAt(r + 1)))) {
        // . element
        r++;
      } else if (path.charAt(r) == '.' && path.charAt(r + 1) == '.' && (r + 2 == n || Os.isPathSeparator(path.charAt(r + 2)))) {
        // .. element: remove to last separator
        r += 2;
        if (out.w > dotdot) {
          // can backtrack
          out.w--;
          while (out.w > dotdot && !Os.isPathSeparator(out.index(out.w))) {
            out.w--;
          }
        } else if (!rooted) {
          // cannot backtrack, but not rooted, so append .. element.
          if (out.w > 0) {
            out.append(SEPARATOR);
          }
          out.append('.');
          out.append('.');
          dotdot = out.w;
        }
      } else {
        // real path element.
        // add slash if needed
        if (rooted && out.w != 1 || !rooted && out.w != 0) {
          out.append(SEPARATOR);
        }
        // copy element
        for (; r < n && !Os.isPathSeparator(path.charAt(r)); r++) {
          out.append(path.charAt(r));
        }
      }
    }

    // Turn empty string into "."
    if (out.w == 0) {
      out.append('.');
    }

    return fromSlash(out.string());
  }

  /**
   * ToSlash returns the result of replacing each separator character
   * in path with a slash ('/') character. Multiple separators are
   * replaced by multiple slashes.
   *
   * @param path
   * @return
   */
  // DONE
  public static String toSlash(String path) {
    if (SEPARATOR == '/') {
      return path;
    }
    // TODO: replace over char array would be more efficient
    return Strings.replace(path, string(SEPARATOR), "/", -1);
  }

  /**
   * FromSlash returns the result of replacing each slash ('/') character
   * in path with a separator character. Multiple slashes are replaced
   * by multiple separators.
   */
  // DONE
  public static String fromSlash(String path) {
    if (SEPARATOR == '/') {
      return path;
    }
    // TODO: replace over char array would be more efficient
    return Strings.replace(path, "/", string(SEPARATOR), -1);
  }

  public static class ErrBadPattern extends /*PatternSyntaxException*/ IllegalArgumentException {
    ErrBadPattern() {
      this(null);
    }
    ErrBadPattern(/*String pattern, int index,*/ Throwable cause) {
      super("syntax error in pattern" /*, pattern, index*/, cause);
    }
  }

  /**
   * match reports whether name matches the shell file name pattern.
   * The pattern syntax is:
   *
   * pattern:
   * 	{ term }* //	term:
   * 	'*'         matches any sequence of non-Separator characters
   * 	'?'         matches any single non-Separator character
   * 	'[' [ '^' ] { character-range } ']'
   * 	            character class (must be non-empty)
   * 	c           matches character c (c != '*', '?', '\\', '[')
   * 	'\\' c      matches character c
   *
   * character-range:
   * 	c           matches character c (c != '\\', '-', ']')
   * 	'\\' c      matches character c
   * 	lo '-' hi   matches character c for lo <= c <= hi
   *
   * Match requires pattern to match all of name, not just a substring.
   * The only possible returned error is ErrBadPattern, when pattern
   * is malformed.
   *
   * On Windows, escaping is disabled. Instead, '\\' is treated as
   * path separator.
   *
   * @param pattern
   * @param name
   * @return
   */
  public boolean match(final String pattern, final String name) {
    int patternLow = 0;
    int nameLow = 0;
    final int patternHigh = len(pattern);
    final int nameHigh = len(name);
    pattern:
    while (patternLow < patternHigh) {
      final ScanChunkResult scanChunkResult = scanChunk(pattern, patternLow);
      final boolean star = scanChunkResult.getStar();
      final int chunkLow = patternLow;
      final int chunkHigh = scanChunkResult.getChunkHigh();
      if (star && chunkLow == chunkHigh) {
        // Trailing * matches rest of string unless it has a /.
        return !Strings.contains(name, nameLow, string(SEPARATOR));
      }
      patternLow = scanChunkResult.getRestLow();
      // Look for match at current position.
      MatchChunkResult matchChunkResult = matchChunk(pattern, chunkLow, chunkHigh, name, nameLow);
      int t = matchChunkResult.getRestLow();
      boolean ok = matchChunkResult.getOk();
      // if we're the last chunk, make sure we've exhausted the name
      // otherwise we'll give a false result even if we could still match
      // using the star
      if (ok && (t == nameHigh || patternLow < patternHigh)) {
        nameLow = t;
        continue;
      }
      if (star) {
        // Look for match skipping i+1 bytes.
        // Cannot skip /.
        for (int i = nameLow; i < nameHigh && name.charAt(i) != SEPARATOR; i++) {
          matchChunkResult = matchChunk(pattern, chunkLow, chunkHigh, name, i + 1);
          t = matchChunkResult.getRestLow();
          ok = matchChunkResult.getOk();
          if (ok) {
            // if we're the last chunk, make sure we exhausted the name
            if (patternLow == patternHigh && t < nameHigh) {
              continue;
            }
            nameLow = t;
            continue pattern;
          }
        }
      }
      return false;
    }
    return len(name) == 0;
  }

  @Value.Immutable(builder = false)
  abstract static class ScanChunkResult {
    @Value.Parameter
    public abstract boolean getStar();
    @Value.Parameter
    public abstract int getChunkHigh();
    public final int getRestLow() {
      return getChunkHigh();
    };
  }

  /**
   * scanChunk gets the next segment of pattern, which is a non-star string
   * possibly preceded by a star.
   *
   * @param pattern
   * @return Tuple of (star, chunk, rest)
   */
  // DONE
  private ScanChunkResult scanChunk(final String pattern, int i /*patternLow*/) {
    final int patternHigh = len(pattern);
    boolean star = false;
    while (i < patternHigh && pattern.charAt(i) == '*') {
      i++;
      star = true;
    }
    boolean inrange = false;
    scan:
    for(; i < patternHigh; i++) {
      switch (pattern.charAt(i)) {
        case '\\':
          if (Runtime.GOOS != WINDOWS) {
            // error check handled in matchChunk: bad pattern.
            if (i + 1 < patternHigh) {
              i++;
            }
          }
          break;
        case '[':
          inrange = true;
          break;
        case ']':
          inrange = false;
          break;
        case '*':
          if (!inrange) {
            break scan;
          }
          break;
      }
    }
    return ImmutableScanChunkResult.of(star, i);
  }

  @Value.Immutable(builder = false)
  abstract static class MatchChunkResult {
    @Value.Parameter
    public abstract int getRestLow();
    @Value.Parameter
    public abstract boolean getOk();
  }

  /**
   * matchChunk checks whether chunk matches the beginning of s.
   * If so, it returns the remainder of s (after the match).
   * Chunk is all single-character operators: literals, char classes, and ?.
   *
   * @param chunk
   * @param s
   * @return Tuple of (rest, ok)
   * @throws ErrBadPattern
   */
  // DONE
  private MatchChunkResult matchChunk(final String chunk, int chunkLow, final int chunkHigh, final String s, int sLow) {
    final int sHigh = len(s);
    Utf8.DecodeRuneInStringResult decodeRuneInStringResult;
    int n;
    boolean ok = true;
    // TOTHINK: put ok check in while condition
    return_loop:
    while (chunkLow < chunkHigh) {
      if (sLow == sHigh) {
        ok = false;
        break return_loop;
      }
      switch (chunk.charAt(chunkLow)) {
        case '[':
          // character class
          decodeRuneInStringResult = Utf8.decodeRuneInString(s, sLow);
          int r = decodeRuneInStringResult.getR();
          n = decodeRuneInStringResult.getSize();
          sLow += n;
          chunkLow++;
          // We can't end right after '[', we're expecting at least
          // a closing bracket and possibly a caret.
          if (chunkLow == chunkHigh) {
            throw new ErrBadPattern();
          }
          // possibly negated
          boolean negated = chunk.charAt(chunkLow) == '^';
          if (negated) {
            chunkLow++;
          }
          // parse all ranges
          boolean match = false;
          int nrange = 0;
          while (true) {
            if (chunkLow < chunkHigh && chunk.charAt(chunkLow) == ']' && nrange > 0){
              chunkLow++;
              break;
            }
            final int lo;
            final int hi;
            GetEscResult getEscResult = getEsc(chunk, chunkLow, chunkHigh);
            lo = getEscResult.getR();
            chunkLow = getEscResult.getNChunkLow();
            if (chunk.charAt(chunkLow) == '-') {
              getEscResult = getEsc(chunk, chunkLow + 1, chunkHigh);
              hi = getEscResult.getR();
              chunkLow = getEscResult.getNChunkLow();
            } else {
              hi = lo;
            }
            if (lo <= r && r <= hi) {
              match = true;
            }
            nrange++;
          }
          if (match == negated) {
            ok = false;
            break return_loop;
          }
          break;

        case '?':
          if (s.charAt(sLow) == SEPARATOR) {
            ok = false;
            break return_loop;
          }
          n = Utf8.decodeRuneInString(s, sLow).getSize();
          sLow += n;
          chunkLow++;
          break;

        case '\\':
          if (Runtime.GOOS != WINDOWS) {
            chunkLow++;
            if (chunkLow == chunkHigh) {
              throw new ErrBadPattern();
            }
          }
          // fallthrough

        default:
          if (chunk.charAt(chunkLow) != s.charAt(sLow)) {
            ok = false;
            break return_loop;
          }
          sLow++;
          chunkLow++;
      }
    } // TODO: Ok is not needed?
    return ImmutableMatchChunkResult.of(sLow, ok);
  }

  @Value.Immutable(builder = false)
  abstract static class GetEscResult {
    @Value.Parameter
    public abstract int getR();
    @Value.Parameter
    public abstract int getNChunkLow();
  }

  /**
   * getEsc gets a possibly-escaped character from chunk, for a character class.
   *
   * Returns size of jump instead of actual new string.
   *
   * @param chunk
   * @param chunkLow
   * @param chunkHigh
   * @return (r, nchunk)
   * @throws ErrBadPattern
   */
  // DONE
  private static GetEscResult getEsc(final String chunk, int chunkLow, final int chunkHigh) {
    if (chunkLow >= chunkHigh || chunk.charAt(chunkLow) == '-' || chunk.charAt(chunkLow) == ']') {
      throw new ErrBadPattern();
    }
    if (chunk.charAt(chunkLow) == '\\' && Runtime.GOOS != WINDOWS) {
      chunkLow++;
      if (chunkLow >= chunkHigh) {
        throw new ErrBadPattern();
      }
    }
    Utf8.DecodeRuneInStringResult decodeRuneInStringResult;
    try {
      decodeRuneInStringResult = Utf8.decodeRuneInString(chunk, chunkLow);
    } catch (Utf8.RuneError e) {
      throw new ErrBadPattern(e);
    }
    chunkLow += decodeRuneInStringResult.getSize();
    if (chunkLow >= chunkHigh) {
      throw new ErrBadPattern();
    }
    return ImmutableGetEscResult.of(decodeRuneInStringResult.getR(), chunkLow);
  }

  /**
   * glob returns the names of all files matching pattern or nil
   * if there is no matching file. The syntax of patterns is the same
   * as in Match. The pattern may describe hierarchical names such as
   * /usr/*&#47;bin/ed(assuming the SEPARATOR is '/').
   *
   * Glob ignores file system errors such as I/O errors reading directories.
   * The only possible returned error is ErrBadPattern, when pattern
   * is malformed.
   *
   * @param pattern
   * @return
   * @throws ErrBadPattern
   * @throws SecurityException - If a security manager exists
   * and its SecurityManager.checkRead(String) method denies read access to the directory
   */
  public List<String> glob(String pattern) {
    if (!hasMeta(pattern)) {
      // Pure Java implementation
      if (!new File(pattern).exists()) {
        return null;
      }
      return ImmutableList.of(pattern);
    }

    SplitResult splitResult = split(pattern);
    String dir = splitResult.getDir();
    String file = splitResult.getFile();
    int volumeLen;
    if (Runtime.GOOS == WINDOWS) {
      CleanGlobPathWindowsResult cleanGlobPathWindowsResult = cleanGlobPathWindows(dir);
      volumeLen = cleanGlobPathWindowsResult.getPrefixLen();
      dir = cleanGlobPathWindowsResult.getCleaned();
    } else {
      volumeLen = 0;
      dir = cleanGlobPath(dir);
    }

    ImmutableList.Builder<String> matches = ImmutableList.builder();

    if (!hasMeta(dir.substring(volumeLen))) {
      glob(dir, file, matches);
      return matches.build();
    }

    // Prevent infinite recursion. See issue 15879.
    if (dir == pattern) {
      throw new ErrBadPattern();
    }

    List<String> m = glob(dir);
    for (String d: m) {
      glob(d, file, matches);
    }
    return matches.build();
  }

  /**
   * cleanGlobPath prepares path for glob matching.
   *
   * @param path
   * @return
   */
  private String cleanGlobPath(String path) {
    if (path.isEmpty()) {
      return ".";
    } else if (string(SEPARATOR).equals(path)) {
      // do nothing to the path
      return path;
    } else {
      return path.substring(0, len(path) - 1); // chop off trailing separator
    }
  }

  @Value.Immutable(builder = false)
  abstract static class CleanGlobPathWindowsResult {
    @Value.Parameter
    public abstract int getPrefixLen();
    @Value.Parameter
    public abstract String getCleaned();
  }

  /**
   * cleanGlobPathWindows is windows version of cleanGlobPath.
   *
   * @param path
   * @return Tuple of (prefixLen, cleaned)
   */
  private CleanGlobPathWindowsResult cleanGlobPathWindows(String path) {
    int length = len(path);
    int vollen = volumeNameLen(path);
    if (path.isEmpty()) {
      return ImmutableCleanGlobPathWindowsResult.of(0, ".");
    } else if (vollen + 1 == length && Os.isPathSeparator(path.charAt(length - 1))) { // /, \, C:\ and C:/
      // do nothing to the path
      return ImmutableCleanGlobPathWindowsResult.of(vollen + 1, path);
    } else if (vollen == length && length == 2) { // C:
      return ImmutableCleanGlobPathWindowsResult.of(vollen, path + '.'); // convert C: into C:.
    } else {
      if (vollen >= length) {
        vollen = length - 1;
      }
      return ImmutableCleanGlobPathWindowsResult.of(vollen, path.substring(0, length - 1)); // chop off trailing separator
    }
  }

  /**
   * glob searches for files matching pattern in the directory dir
   * and appends them to matches. If the directory cannot be
   * opened, it returns the existing matches. New matches are
   * added in lexicographical order.
   *
   * @param dir
   * @param pattern
   * @param matches
   * @throws SecurityException - If a security manager exists
   * and its SecurityManager.checkRead(String) method denies read access to the directory
   * @return
   */
  private void glob(String dir, String pattern, ImmutableList.Builder<String> matches) {
    // Pure Java implementation
    File d = new File(dir);
    if (!d.isDirectory()) {
      return;
    }
    String[] names = d.list(
      new FilenameFilter() {
        @Override
        public boolean accept(File dir, String n) {
          return match(pattern, n);
        }
      }
    );
    Sort.strings(names);
    for (String n: names) {
      matches.add(join(dir, n));
    }
  }

  private static final String MAGIC_CHARS = Runtime.GOOS == WINDOWS ? "*?[" : "*?[\\";

  /**
   * hasMeta reports whether path contains any of the magic characters
   * recognized by {@link #match}.
   *
   * @param path
   * @return
   */
  private boolean hasMeta(String path) {
    return Strings.containsAny(path, MAGIC_CHARS);
  }

  /**
   * Join joins any number of path elements into a single path, adding
   * a Separator if necessary. Join calls Clean on the result; in particular,
   * all empty Strings are ignored.
   * On Windows, the result is a UNC path if and only if the first path
   * element is a UNC path.
   *
   * @param elem
   * @return
   */
  // DONE
  public static String join(String... elem) {
    int elemHigh = len(elem);
    for (int i = 0; i < elemHigh; i++) {
      String e = elem[i];
      if (!e.isEmpty()) {
        if (Runtime.GOOS == WINDOWS) {
          return joinNonEmpty(elem, i);
        } else {
          return clean(Strings.join(elem, i, string(SEPARATOR)));
        }
      }
    }
    return "";
  }


  /**
   * joinNonEmpty is like join, but it assumes that the first element is non-empty.
   *
   * @param elem
   * @return
   */
  // DONE
  private static String joinNonEmpty(String[] elem, int elemLow) {
    if (len(elem[elemLow]) == 2 && elem[elemLow].charAt(1) == ':') {
      // First element is drive letter without terminating slash.
      // Keep path relative to current directory on that drive.
      return clean(elem[elemLow] + Strings.join(elem, elemLow + 1, string(SEPARATOR)));
    }
    // The following logic prevents Join from inadvertently creating a
    // UNC path on Windows. Unless the first element is a UNC path, Join
    // shouldn't create a UNC path. See golang.org/issue/9167.
    String p = clean(Strings.join(elem, elemLow, string(SEPARATOR)));
    if (!isUNC(p)) {
      return p;
    }
    // p == UNC only allowed when the first element is a UNC path.
    String head = clean(elem[elemLow]);
    if (isUNC(head)) {
      return p;
    }
    // head + tail == UNC, but joining two non-UNC paths should not result
    // in a UNC path. Undo creation of UNC path.
    String tail = clean(Strings.join(elem, elemLow + 1, string(SEPARATOR)));
    if (head.charAt(len(head) - 1) == SEPARATOR) {
      return head + tail;
    }
    return head + SEPARATOR + tail;
  }

  @Value.Immutable(builder = false)
  public abstract static class SplitResult {
    @Value.Parameter
    public abstract String getDir();
    @Value.Parameter
    public abstract String getFile();
  }

  /**
   * Split splits path immediately following the final Separator,
   * separating it into a directory and file name component.
   * If there is no Separator in path, Split returns an empty dir
   * and file set to path.
   * The returned values have the property that path = dir+file.
   *
   * @param path
   * @return (dir, file)
   */
  public static SplitResult split(String path) {
    int volNameLen = volumeNameLen(path);
    int i = len(path) - 1;
    while (i >= volNameLen && !Os.isPathSeparator(path.charAt(i))) {
      i--;
    }
    return ImmutableSplitResult.of(path.substring(0, i + 1), path.substring(i + 1));
  }

  /**
   * VolumeName returns length of the leading volume name on Windows.
   * Given "C:\foo\bar" it returns 2 on Windows.
   * Given "\\host\share\foo" it returns "\\host\share".
   * On other platforms it returns 0.
   *
   * Note: it is not exported in Go. It is made public in Java port for convenience,
   * to avoid unnecessary String creation
   *
   * @param path
   * @return
   */
  // DONE
  public static int volumeNameLen(String path) {
    if (Runtime.GOOS == WINDOWS) {
      if (len(path) < 2) {
        return 0;
      }
      // with drive letter
      char c = path.charAt(0);
      if (path.charAt(1) == ':' && ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z')) {
        return 2;
      }
      // is it UNC? https://msdn.microsoft.com/en-us/library/windows/desktop/aa365247(v=vs.85).aspx
      int l;
      if ((l = len(path)) >= 5 && isSlash(path.charAt(0)) && isSlash(path.charAt(1)) &&
              !isSlash(path.charAt(2)) && path.charAt(2) != '.') {
        // first, leading `\\` and next shouldn't be `\`. its server name.
        for (int n = 3; n < l - 1; n++) {
          // second, next '\' shouldn't be repeated.
          if (isSlash(path.charAt(n))) {
            n++;
            // third, following something characters. its share name.
            if (!isSlash(path.charAt(n))) {
              if (path.charAt(n) == '.') {
                break;
              }
              for (; n < l; n++) {
                if (isSlash(path.charAt(n))) {
                  break;
                }
              }
              return n;
            }
            break;
          }
        }
      }
    }
    return 0;
  }

  private static boolean isSlash(char c) {
    return c == '\\' || c == '/';
  }

  /**
   * isUNC reports whether path is a UNC path.
   * @param path
   * @return
   */
  // DONE
  private static boolean isUNC(String path) {
    return volumeNameLen(path) > 2;
  }

  private FilePath() {}
}
