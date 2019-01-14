package go;

import com.google.common.primitives.UnsignedInteger;
import org.joou.UByte;
import org.joou.UInteger;
import org.joou.UNumber;
import org.joou.UShort;

/**
 * Note: all implementations are pure Java
 */
public final class Conversions {
  /**
   * Converting a signed or unsigned integer value to a string type yields a string
   * containing the UTF-8 representation of the integer.
   * TODO: Values outside the range of valid Unicode code points are converted to "\uFFFD".
   *
   * @param c
   * @return
   */
  public static String string(char c) {
    return String.valueOf(c);
  }

  /**
   * Converting a signed or unsigned integer value to a string type yields a string
   * containing the UTF-8 representation of the integer.
   * TODO: Values outside the range of valid Unicode code points are converted to "\uFFFD".
   *
   * @param i
   * @return
   */
  public static String string(int i) {
    return new String(Character.toChars(i));
  }

  /**
   * Converting a signed or unsigned integer value to a string type yields a string
   * containing the UTF-8 representation of the integer.
   * TODO: Values outside the range of valid Unicode code points are converted to "\uFFFD".
   *
   * @param i
   * @return
   */
  public static String string(UInteger i) {
    return new String(Character.toChars(i.intValue()));
  }

  /**
   * Converting a signed or unsigned integer value to a string type yields a string
   * containing the UTF-8 representation of the integer.
   * TODO: Values outside the range of valid Unicode code points are converted to "\uFFFD".
   *
   * @param i
   * @return
   */
  public static String string(UnsignedInteger i) {
    return new String(Character.toChars(i.intValue()));
  }

  /**
   * Converting a slice of bytes to a string type yields a string whose successive bytes are the elements of the slice.
   *
   * @param c
   * @return
   */
  public static String string(final char[] c) {
    return string(c, 0, c.length);
  }

  /**
   * Converting a slice of bytes to a string type yields a string whose successive bytes are the elements of the slice.
   *
   * @param c
   * @return
   */
  public static String string(final char[] c, int beginIndex) {
    return string(c, beginIndex, c.length);
  }

  /**
   * Converting a slice of bytes to a string type yields a string whose successive bytes are the elements of the slice.
   *
   * @param c
   * @return
   */
  public static String string(final char[] c, int beginIndex, int endIndex) {
    return new String(c, beginIndex, endIndex - beginIndex);
  }

  /**
   * Converting a slice of runes to a string type yields a string
   * that is the concatenation of the individual rune values converted to Strings.
   *
   * @param c
   * @return
   */
  public static String string(final int[] c) {
    return string(c, 0, c.length);
  }

  /**
   * Converting a slice of runes to a string type yields a string
   * that is the concatenation of the individual rune values converted to Strings.
   *
   * @param c
   * @return
   */
  public static String string(final int[] c, int beginIndex) {
    return string(c, beginIndex, c.length);
  }

  /**
   * Converting a slice of runes to a string type yields a string
   * that is the concatenation of the individual rune values converted to Strings.
   *
   * @param c
   * @return
   */
  public static String string(final int[] c, int beginIndex, int endIndex) {
    return new String(c, beginIndex, endIndex - beginIndex);
  }

  /**
   * Converting a value of a string type to a slice of bytes type
   * yields a slice whose successive elements are the bytes of the string.
   *
   * @param s
   * @return
   */
  public static char[] bytes(final String s) {
    return s.toCharArray();
  }

  /**
   * Converting a value of a string type to a slice of runes type
   * yields a slice containing the individual Unicode code points of the string.
   *
   * @param s
   * @return
   */
  public static int[] runes(final String s) {
    return s.codePoints().toArray();
  }

  public static long int64(byte i) {
    return i;
  }

  public static long int64(UByte i) {
    return i.longValue();
  }

  public static long int64(short i) {
    return i;
  }

  public static long int64(UShort i) {
    return i.longValue();
  }

  public static long int64(int i) {
    return i;
  }

  public static long int64(UInteger i) {
    return i.longValue();
  }

  public static long int64(UnsignedInteger i) {
    return i.longValue();
  }

  private Conversions() {}
}
