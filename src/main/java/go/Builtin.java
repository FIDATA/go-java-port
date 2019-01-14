package go;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Package Builtin provides Go's predeclared identifiers.
 * In Go, these items are not actually in package builtin,
 * they are just documented to be there.
 *
 * Usage:
 * {@code import static go.Builtin.Builtin.*}
 *
 * Note: all implementations are pure Java
 *
 * Differences with Go:
 * * len function: // TODOC: fix links, format code etc.
 *   * (Pointer to) array: if v is null, {@link NullPointerException} is thrown.
 *     In Go len(v) returns actual (declared) number of elements
 *   * String: the number of Unicode code units in v (the same as {@link String#length()}).
 *     In Go len(v) returns the number of bytes
 *   * Channel: not implemented
 */
public final class Builtin {
  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, final boolean[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, int dstLow, final boolean[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, int dstLow, int dstHigh, final boolean[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, final boolean[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, int dstLow, final boolean[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, int dstLow, int dstHigh, final boolean[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, final boolean[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, int dstLow, final boolean[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final boolean[] dst, int dstLow, int dstHigh, final boolean[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, final byte[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, int dstLow, final byte[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, int dstLow, int dstHigh, final byte[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, final byte[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, int dstLow, final byte[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, int dstLow, int dstHigh, final byte[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, final byte[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, int dstLow, final byte[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final byte[] dst, int dstLow, int dstHigh, final byte[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, final char[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, final char[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, int dstHigh, final char[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, final char[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, final char[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, int dstHigh, final char[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, final char[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, final char[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, int dstHigh, final char[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, final short[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, int dstLow, final short[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, int dstLow, int dstHigh, final short[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, final short[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, int dstLow, final short[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, int dstLow, int dstHigh, final short[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, final short[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, int dstLow, final short[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final short[] dst, int dstLow, int dstHigh, final short[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, final int[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, int dstLow, final int[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, int dstLow, int dstHigh, final int[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, final int[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, int dstLow, final int[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, int dstLow, int dstHigh, final int[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, final int[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, int dstLow, final int[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final int[] dst, int dstLow, int dstHigh, final int[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, final long[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, int dstLow, final long[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, int dstLow, int dstHigh, final long[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, final long[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, int dstLow, final long[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, int dstLow, int dstHigh, final long[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, final long[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, int dstLow, final long[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final long[] dst, int dstLow, int dstHigh, final long[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, final float[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, int dstLow, final float[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, int dstLow, int dstHigh, final float[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, final float[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, int dstLow, final float[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, int dstLow, int dstHigh, final float[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, final float[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, int dstLow, final float[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final float[] dst, int dstLow, int dstHigh, final float[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, final double[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, int dstLow, final double[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, int dstLow, int dstHigh, final double[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, final double[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, int dstLow, final double[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, int dstLow, int dstHigh, final double[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, final double[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, int dstLow, final double[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final double[] dst, int dstLow, int dstHigh, final double[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, final Object[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, int dstLow, final Object[] src) {
    return copyInternalImpl(dst, dstLow, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, int dstLow, int dstHigh, final Object[] src) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, final Object[] src, int srcLow) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, int dstLow, final Object[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, int dstLow, int dstHigh, final Object[] src, int srcLow) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, final Object[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, int dstLow, final Object[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final Object[] dst, int dstLow, int dstHigh, final Object[] src, int srcLow, int srcHigh) {
    return copyInternalImpl(dst, dstLow, dstHigh, src, srcLow, srcHigh);
  }

  private static int copyInternalImpl(Object dst, int dstLow, int dstHigh, Object src, int srcLow, int srcHigh) {
    int length = Math.min(dstHigh - dstLow, srcHigh - srcLow);
    System.arraycopy(src, srcLow, dst, dstLow, length);
    return length;
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, final String src) {
    return copy(dst, 0, dst.length, src, 0, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, final String src) {
    return copy(dst, dstLow, dst.length, src, 0, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, int dstHigh, final String src) {
    return copy(dst, dstLow, dstHigh, src, 0, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, final String src, int srcLow) {
    return copy(dst, 0, dst.length, src, srcLow, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, final String src, int srcLow) {
    return copy(dst, dstLow, dst.length, src, srcLow, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, int dstHigh, final String src, int srcLow) {
    return copy(dst, dstLow, dstHigh, src, srcLow, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, final String src, int srcLow, int srcHigh) {
    return copy(dst, 0, dst.length, src, srcLow, srcHigh);
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, final String src, int srcLow, int srcHigh) {
    return copy(dst, dstLow, dst.length, src, srcLow, srcHigh);
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstLow destination slice starting index, including
   * @param dstHigh destination slice ending index, excluding
   * @param src source array
   * @param srcLow source slice starting index, including
   * @param srcHigh source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(final char[] dst, int dstLow, int dstHigh, final String src, int srcLow, int srcHigh) {
    int length = Math.min(dstHigh - dstLow, srcHigh - srcLow);
    src.getChars(srcLow, srcLow + length, dst, dstLow);
    return length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final boolean[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final byte[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final char[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final short[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final int[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final long[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final float[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final double[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(final Object[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Collection
   * @return The number of Unicode code units in v. If v is null, len(v) is zero.
   */
  public static int len(Collection v) {
    return v == null ? 0 : v.size();
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Map
   * @return The number of elements in v; if v is null, len(v) is zero.
   */
  public static int len(Map v) {
    return v == null ? 0 : v.size();
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v String
   * @return The number of Unicode code units in v
   * @throws NullPointerException If v is null
   */
  public static int len(String v) {
    return v.length();
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
  */
  public static boolean[] makebooleans(int size) {
    return new boolean[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static byte[] makebytes(int size) {
    return new byte[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static char[] makechars(int size) {
    return new char[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static short[] makeshorts(int size) {
    return new short[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static int[] makeints(int size) {
    return new int[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static long[] makelongs(int size) {
    return new long[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static float[] makefloats(int size) {
    return new float[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static double[] makedoubles(int size) {
    return new double[size];
  }

  /**
   * The make built-in function allocates and initializes an object of type
   * slice, map, or chan (only). Like new, the first argument is a type, not a
   * value. Unlike new, make's return type is the same as the type of its
   * argument, not a pointer to it. The specification of the result depends on
   * the type:
   * 	Slice: The size specifies the length. The capacity of the slice is
   * 	equal to its length. A second integer argument may be provided to
   * 	specify a different capacity; it must be no smaller than the
   * 	length. For example, final make([]int, 0, 10) allocates an underlying array
   * 	of size 10 and returns a slice of length 0 and capacity 10 that is
   * 	backed by this underlying array.
   * 	Map: An empty map is allocated with enough space to hold the
   * 	specified number of elements. The size may be omitted, in which case
   * 	a small starting size is allocated.
   * 	Channel: The channel's buffer is initialized with the specified
   * 	buffer capacity. If zero, or the size is omitted, the channel is
   * 	unbuffered.
   *
   * Java implementation notices:
   * *  For primitives, function doesn't accept Type arguments. Instead, function name changed
   * *  Version with two integers is not provided
   */
  public static <T> T[] make(Class<T> t, int size) {
    @SuppressWarnings("unchecked")
    final T[] a = (T[])Array.newInstance(t, size);
    return a;
  }

  private Builtin() {}
}
