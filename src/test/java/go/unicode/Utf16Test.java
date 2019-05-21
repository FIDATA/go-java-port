/*
 * Tests for Java port of Go unicode/utf8 package
 * Copyright ©  Basil Peace
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

import static go.unicode.Utf16.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.immutables.value.Value;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;

import javax.annotation.Nullable;

@RunWith(JUnitParamsRunner.class)
public final class Utf16Test {
  @Rule
  public final ExpectedException expectedException = ExpectedException.none();

  // TODO: Try to use tests from src/unicode/utf8/utf8_test.go too

  /*
   * Source files:
   * src/unicode/utf16/utf16_test.go
   */
  @Value.Immutable(builder = false)
  public abstract static class EncodeTest {
    @Value.Parameter
    public abstract int[] getIn();
    @Value.Parameter
    public abstract char[] getOut();
  }

  public final EncodeTest[] encodeTests() {
    return new EncodeTest[]{
      ImmutableEncodeTest.of(new int[]{1, 2, 3, 4}, new char[]{1, 2, 3, 4}),
      ImmutableEncodeTest.of(
        new int[]{0xffff, 0x10000, 0x10001, 0x12345, 0x10ffff},
        new char[]{0xffff, 0xd800, 0xdc00, 0xd800, 0xdc01, 0xd808, 0xdf45, 0xdbff, 0xdfff}
      ),
      ImmutableEncodeTest.of(
        new int[]{'a', 'b', 0xd7ff, 0xd800, 0xdfff, 0xe000, 0x110000, -1},
        new char[]{'a', 'b', 0xd7ff, 0xfffd, 0xfffd, 0xe000, 0xfffd, 0xfffd}
      ),
    };
  }

  /*
   * CAVEAT:
   * Since we don't have encodeRune ported and test decodeRuneInString only,
   * we use testing strategy different from Go
   */
  @Test
  @Parameters(method = "encodeTests")
  @TestCaseName("testDecodeRuneOnEncodeTest[{index}]")
  public void testDecodeRuneOnEncodeTest(EncodeTest tt) {
    int j = 0;

    String outAsString = new String(tt.getOut());

    for (int r : tt.getIn()) {
      if (tt.getOut()[j] == /* TODO: unicode.ReplacementChar */ 0xfffd) {
        j++;
        assertFalse("ran out of tt.out", j > tt.getOut().length);
      } else {
        DecodeRuneInStringResult decodeRuneInStringResult = decodeRuneInString(tt.getOut(), j);
        int dec = decodeRuneInStringResult.getR();
        // TODO: Format decodeRuneInString(%#x, %d) = %#x; want %#x
        // TODO: StringUtils.join(tt.getOut(), ", ")
        assertEquals(String.format("decodeRuneInString(%s, %d) = %s; want %s", DefaultGroovyMethods.inspect(tt.getOut()), j, DefaultGroovyMethods.inspect(dec), DefaultGroovyMethods.inspect(r)), r, dec);

        decodeRuneInStringResult = decodeRuneInString(outAsString, j);
        dec = decodeRuneInStringResult.getR();
        // TODO: # format decodeRuneInString(%#x, %d) = %#x; want %#x
        assertEquals(String.format("decodeRuneInString(%s, %d) = %s; want %s", DefaultGroovyMethods.inspect(outAsString), j, DefaultGroovyMethods.inspect(dec), DefaultGroovyMethods.inspect(r)), r, dec);

        j += decodeRuneInStringResult.getSize();
        assertFalse("ran out of tt.out", j > tt.getOut().length);
      }
    }
    assertEquals("EncodeRune didn't generate enough output", j, tt.getOut().length);
  }

  @Value.Immutable(builder = false)
  public abstract static class DecodeRuneTest {
    /*
     * CAVEAT:
     * Go for some unknown reason uses rune type for DecodeRune inputs.
     * I assume it is a bug, they should be of uint16 type
     * <grv87 2019-03-14>
     */
    @Value.Parameter
    public abstract char getR1();
    @Value.Parameter
    public abstract char getR2();
    @Value.Parameter
    public abstract int getWant();
    @Value.Parameter
    @Nullable
    public abstract Class<? extends Throwable> getExpectedException();
  }

  public final Object decodeRuneTests() {
    return new DecodeRuneTest[]{
      ImmutableDecodeRuneTest.of((char)0xd800, (char)0xdc00, 0x10000, null),
      ImmutableDecodeRuneTest.of((char)0xd800, (char)0xdc01, 0x10001, null),
      ImmutableDecodeRuneTest.of((char)0xd808, (char)0xdf45, 0x12345, null),
      ImmutableDecodeRuneTest.of((char)0xdbff, (char)0xdfff, 0x10ffff, null),
      ImmutableDecodeRuneTest.of((char)0xd800, 'a', 0xfffd, RuneError.class), // illegal, replacement rune substituted
    };
  };

  @Test
  @Parameters(method = "decodeRuneTests")
  @TestCaseName("testDecodeRuneInStringOnDecodeRuneTest[{index}]")
  public void testDecodeRuneInStringOnDecodeRuneTest(DecodeRuneTest tt) {
    String rString = new String(new char[]{tt.getR1(), tt.getR2()});
    if (tt.getExpectedException() != null) {
      expectedException.expect(tt.getExpectedException());
    }
    int got = decodeRuneInString(rString).getR();
    // TODO: format DecodeRune(%q, %q) = %v; want %v
    assertEquals(String.format("decodeRuneInString(%s) = %s; want %s", DefaultGroovyMethods.inspect(rString), got, tt.getWant()), got, tt.getWant());
  }
}
