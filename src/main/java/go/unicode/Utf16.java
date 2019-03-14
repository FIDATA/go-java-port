/*
 * Java port of Go unicode/utf8 package
 * Copyright © 2019  Basil Peace
 * Copyright 2009 The Go Authors. All rights reserved.
 *
 * This file is part of go-java-port.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Basil Peace designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Basil Peace in the LICENSE file that accompanied this code.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package go.unicode;

import org.immutables.value.Value;
import java.nio.charset.CharacterCodingException;
import java.io.IOException;

/**
 * In Go, package {@code utf8} implements functions and constants to support text encoded in
 * UTF-8. It includes functions to translate between runes and UTF-8 byte sequences.
 *
 * Since JVM stores Strings in UTF-16, methods, accepting or returning String,
 * actually works with UTF-16, but provide the same functionality.
 */
/*
 * Source files:
 * src/unicode/utf8/utf8.go
 */
public final class Utf16 {
  /**
   * The "error" Rune
   *
   * CAVEAT:
   * Although Java has {@link CharacterCodingException}, it extends {@link IOException}.
   * {@code RuneError} exception is not necessary raised in IO, so extending {@link IOException}
   * makes no sense.
   * Also, {@link IOException} is checked exception while we wish to have unchecked.
   */
  public static class RuneError extends RuntimeException {
    RuneError() {
      this(null);
    }
    RuneError(Throwable cause) {
      super("The \"error\" Rune", cause);
    }
  }

  /**
   * Class to store result of {@link #decodeRuneInString(String)} invocation
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
   * UTF-16.
   *
   * An encoding is invalid if it is incorrect UTF-16, encodes a rune that is
   * out of range, or is not the shortest possible UTF-16 encoding for the
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
   * UTF-16.
   *
   * An encoding is invalid if it is incorrect UTF-16, encodes a rune that is
   * out of range, or is not the shortest possible UTF-16 encoding for the
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
    // Code copied from java.lang.Character#codePointAt(char[], int, int)
    // and java.lang.Character#codePointAtImpl(char[], int, int)
    // and changed to throw RuneError
    int limit = s.length();
    if (index == limit) {
      throw new RuneError();
    } else if ((index < 0) || (index > limit)) {
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
   * UTF-16.
   *
   * An encoding is invalid if it is incorrect UTF-16, encodes a rune that is
   * out of range, or is not the shortest possible UTF-16 encoding for the
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
    // Code copied from java.lang.Character#codePointAt(char[], int, int)
    // and java.lang.Character#codePointAtImpl(char[], int, int)
    // and changed to work with char array and throw RuneError
    int limit = s.length;
    if ((index < 0) || (index >= limit)) {
      throw new ArrayIndexOutOfBoundsException(index);
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

  private Utf16() {};
}
