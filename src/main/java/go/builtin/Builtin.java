package go.builtin;

import java.util.Collection;
import java.util.Map;

/**
 * Package builtin provides Go's predeclared identifiers.
 * In Go, these items are not actually in package builtin,
 * they are just documented to be there.
 *
 * Usage:
 * {@code import static go.builtin.Builtin.*}
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
  public static int copy(boolean[] dst, boolean[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, int dstBegin, boolean[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, int dstBegin, int dstEnd, boolean[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, boolean[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, int dstBegin, boolean[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, int dstBegin, int dstEnd, boolean[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, boolean[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, int dstBegin, boolean[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(boolean[] dst, int dstBegin, int dstEnd, boolean[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(byte[] dst, byte[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, int dstBegin, byte[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, int dstBegin, int dstEnd, byte[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, byte[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, int dstBegin, byte[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, int dstBegin, int dstEnd, byte[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, byte[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, int dstBegin, byte[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(byte[] dst, int dstBegin, int dstEnd, byte[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(char[] dst, char[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, char[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, int dstEnd, char[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, char[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, char[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, int dstEnd, char[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, char[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, char[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, int dstEnd, char[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(short[] dst, short[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, int dstBegin, short[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, int dstBegin, int dstEnd, short[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, short[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, int dstBegin, short[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, int dstBegin, int dstEnd, short[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, short[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, int dstBegin, short[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(short[] dst, int dstBegin, int dstEnd, short[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(int[] dst, int[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int dstBegin, int[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int dstBegin, int dstEnd, int[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int dstBegin, int[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int dstBegin, int dstEnd, int[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int dstBegin, int[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(int[] dst, int dstBegin, int dstEnd, int[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(long[] dst, long[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, int dstBegin, long[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, int dstBegin, int dstEnd, long[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, long[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, int dstBegin, long[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, int dstBegin, int dstEnd, long[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, long[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, int dstBegin, long[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(long[] dst, int dstBegin, int dstEnd, long[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(float[] dst, float[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, int dstBegin, float[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, int dstBegin, int dstEnd, float[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, float[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, int dstBegin, float[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, int dstBegin, int dstEnd, float[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, float[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, int dstBegin, float[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(float[] dst, int dstBegin, int dstEnd, float[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(double[] dst, double[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, int dstBegin, double[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, int dstBegin, int dstEnd, double[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, double[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, int dstBegin, double[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, int dstBegin, int dstEnd, double[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, double[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, int dstBegin, double[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(double[] dst, int dstBegin, int dstEnd, double[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
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
  public static int copy(Object[] dst, Object[] src) {
    return copyInternalImpl(dst, 0, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, int dstBegin, Object[] src) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, int dstBegin, int dstEnd, Object[] src) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, 0, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, Object[] src, int srcBegin) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, int dstBegin, Object[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, int dstBegin, int dstEnd, Object[] src, int srcBegin) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, src.length);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, Object[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, int dstBegin, Object[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * The copy built-in function copies elements from a source slice into a
   * destination slice. The source and destination may overlap. Copy
   * returns the number of elements copied, which will be the minimum of
   * len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(Object[] dst, int dstBegin, int dstEnd, Object[] src, int srcBegin, int srcEnd) {
    return copyInternalImpl(dst, dstBegin, dstEnd, src, srcBegin, srcEnd);
  }

  private static int copyInternalImpl(Object dst, int dstBegin, int dstEnd, Object src, int srcBegin, int srcEnd) {
    int length = Math.min(dstEnd - dstBegin, srcEnd - srcBegin);
    System.arraycopy(src, srcBegin, dst, dstBegin, length);
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
  public static int copy(char[] dst, String src) {
    return copy(dst, 0, dst.length, src, 0, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, String src) {
    return copy(dst, dstBegin, dst.length, src, 0, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, int dstEnd, String src) {
    return copy(dst, dstBegin, dstEnd, src, 0, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, String src, int srcBegin) {
    return copy(dst, 0, dst.length, src, srcBegin, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, String src, int srcBegin) {
    return copy(dst, dstBegin, dst.length, src, srcBegin, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, int dstEnd, String src, int srcBegin) {
    return copy(dst, dstBegin, dstEnd, src, srcBegin, src.length());
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, String src, int srcBegin, int srcEnd) {
    return copy(dst, 0, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, String src, int srcBegin, int srcEnd) {
    return copy(dst, dstBegin, dst.length, src, srcBegin, srcEnd);
  }

  /**
   * A special case of copy built-in function that copies chars from a
   * string to a slice of chars. Copy returns the number of elements
   * copied, which will be the minimum of len(src) and len(dst).
   *
   * @param dst destination array
   * @param dstBegin destination slice starting index, including
   * @param dstEnd destination slice ending index, excluding
   * @param src source array
   * @param srcBegin source slice starting index, including
   * @param srcEnd source slice ending index, excluding
   * @return the number of elements copied
   * @throws NullPointerException if src or dst is null
   * @throws IndexOutOfBoundsException if array bounds are out of range
   */
  public static int copy(char[] dst, int dstBegin, int dstEnd, String src, int srcBegin, int srcEnd) {
    int length = Math.min(dstEnd - dstBegin, srcEnd - srcBegin);
    src.getChars(srcBegin, srcBegin + length, dst, dstBegin);
    return length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(boolean[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(byte[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(char[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(short[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(int[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(long[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(float[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(double[] v) {
    return v.length;
  }

  /**
   * The len built-in function returns the length of v, according to its type.
   *
   * @param v Array
   * @return The number of elements in v
   * @throws NullPointerException If v is null
   */
  public static int len(Object[] v) {
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

  private Builtin() {}
}
