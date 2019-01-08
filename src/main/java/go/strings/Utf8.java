package go.strings;

import org.immutables.value.Value;

/**
 * In Go, package Utf8 implements functions and constants to support text encoded in
 * UTF-8. It includes functions to translate between runes and UTF-8 byte sequences.
 * package Utf8
 *
 * Since JVM stores Strings in UTF-16, methods, accepting or returning String,
 * actually works with UTF-16, but provide the same functionality.
 */
public final class Utf8 {
  /**
   * The "error" Rune
   */
  public static class RuneError extends /*CharacterCodingException*/ RuntimeException {
    RuneError() {
      this(null);
    }
    RuneError(Throwable cause) {
      super("The \"error\" Rune", cause);
    }
  }

  /**
   *
   */
  @Value.Immutable(builder = false)
  public abstract static class DecodeRuneInStringResult {
    @Value.Parameter
    public abstract int getR();
    @Value.Parameter
    public abstract int getSize();
  }

  /**
   * DecodeRuneInString is like DecodeRune but its input is a string. If s is
   * empty it returns (RuneError, 0). Otherwise, if the encoding is invalid, it
   * returns (RuneError, 1). Both are impossible results for correct, non-empty
   * UTF-8.
   *
   * An encoding is invalid if it is incorrect UTF-8, encodes a rune that is
   * out of range, or is not the shortest possible UTF-8 encoding for the
   * value. No other validation is performed.
   * @param s
   * @return (r, size)
   */
  public static DecodeRuneInStringResult decodeRuneInString(String s) {
    return decodeRuneInString(s, 0);
  }

  /**
   * DecodeRuneInString is like DecodeRune but its input is a string. If s is
   * empty it throws RuneError. If the encoding is invalid, it
   * throws RuneError too. Both are impossible results for correct, non-empty
   * UTF-8.
   *
   * An encoding is invalid if it is incorrect UTF-8, encodes a rune that is
   * out of range, or is not the shortest possible UTF-8 encoding for the
   * value. No other validation is performed.
   * @param s
   * @param index
   * @return (r, size)
   * @exception  IndexOutOfBoundsException  if the {@code index}
   *             argument is negative or not less than the length of this
   *             string.
   * @exception  RuneError
   */
  public static DecodeRuneInStringResult decodeRuneInString(String s, int index) {
    int limit = s.length();
    if ((index < 0) || (index >= limit)) {
      throw new StringIndexOutOfBoundsException(index);
    }
    char c1 = s.charAt(index);
    if (Character.isHighSurrogate(c1)) {
      if (++index < limit) {
        char c2 = s.charAt(index);
        if (Character.isLowSurrogate(c2)) {
          return ImmutableDecodeRuneInStringResult.of(Character.toCodePoint(c1, c2), 2);
        }
      }
      throw new RuneError();
    }
    // TOTEST: No other checks are required ?
    return ImmutableDecodeRuneInStringResult.of((int)c1, 1);
  }

  /**
   * DecodeRuneInString is like DecodeRune but its input is a string. If s is
   * empty it throws RuneError. If the encoding is invalid, it
   * throws RuneError too. Both are impossible results for correct, non-empty
   * UTF-8.
   *
   * An encoding is invalid if it is incorrect UTF-8, encodes a rune that is
   * out of range, or is not the shortest possible UTF-8 encoding for the
   * value. No other validation is performed.
   * @param s
   * @param index
   * @return (r, size)
   * @exception  IndexOutOfBoundsException  if the {@code index}
   *             argument is negative or not less than the length of this
   *             string.
   * @exception  RuneError
   */
  public static DecodeRuneInStringResult decodeRuneInString(char[] s, int index) {
    int limit = s.length;
    if ((index < 0) || (index >= limit)) {
      throw new StringIndexOutOfBoundsException(index);
    }
    char c1 = s[index];
    if (Character.isHighSurrogate(c1)) {
      if (++index < limit) {
        char c2 = s[index];
        if (Character.isLowSurrogate(c2)) {
          return ImmutableDecodeRuneInStringResult.of(Character.toCodePoint(c1, c2), 2);
        }
      }
      throw new RuneError();
    }
    // TOTEST: No other checks are required ?
    return ImmutableDecodeRuneInStringResult.of((int)c1, 1);
  }

  private Utf8() {};
}
