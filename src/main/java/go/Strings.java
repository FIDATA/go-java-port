package go;

import static go.Builtin.*;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.StringJoiner;

public final class Strings {
  /**
   * Contains reports whether substr is within s.
   *
   * @param s
   * @param substr
   * @return
   */
  public static boolean contains(String s, String substr) {
    // return s.contains(substr);
    return contains(s, 0, substr);
  }

  /**
   * Contains reports whether substr is within s.
   *
   * @param s
   * @param substr
   * @return
   */
  public static boolean contains(String s, int sLow, String substr) {
    return s.indexOf(substr, sLow) > -1;
  }

  /**
   * ContainsAny reports whether any Unicode code points in chars are within s.
   *
   * @param s
   * @param chars
   * @return
   */
  public static boolean containsAny(String s, String chars) {
    return StringUtils.containsAny(s, chars);
  }

  /**
   * ContainsRune reports whether the Unicode code point r is within s.
   *
   * @param s
   * @param r
   * @return
   */
  public static boolean contains(String s, char r) {
    return s.indexOf(r) > -1;
  }

  /**
   * Join concatenates the elements of a to create a single string. The separator string
   * sep is placed between elements in the resulting string.
   */
  public static String join(String[] a, String sep) {
    return join(a, 0, sep);
  }

  /**
   * Join concatenates the elements of a to create a single string. The separator string
   * sep is placed between elements in the resulting string.
   */
  public static String join(String[] a, int start, String sep) {
    return join(a, start, len(a), sep);
  }

  /**
   * Join concatenates the elements of a to create a single string. The separator string
   * sep is placed between elements in the resulting string.
   */
  public static String join(String[] a, int start, int end, String sep) {
    // Code copied from java.lang.String#join(CharSequence, CharSequence...)
    Objects.requireNonNull(sep);
    Objects.requireNonNull(a);
    // Number of elements not likely worth Arrays.stream overhead.
    StringJoiner joiner = new StringJoiner(sep);
    for (int i = start; i < end; i++) {
      joiner.add(a[i]);
    }
    return joiner.toString();
  }

  /**
   * Replace returns a copy of the string s with the first n
   * non-overlapping instances of old replaced by new.
   * If old is empty, it matches at the beginning of the string
   * and after each UTF-8 sequence, yielding up to k+1 replacements
   * for a k-rune string.
   * If n < 0, there is no limit on the number of replacements.
   */
  public static String replace(String s, String old, String aNew, int n) {
    return StringUtils.replace(s, old, aNew, n < 0 ? -1 : n);
  }

  private Strings() {}
}
