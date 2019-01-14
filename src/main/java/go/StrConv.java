package go;

import static go.Conversions.*;
import com.google.common.primitives.UnsignedLong;
import org.joou.ULong;

import java.math.BigInteger;

public final class StrConv {
  /**
   * FormatUint returns the string representation of i in the given base,
   * for 2 <= base <= 36. The result uses the lower-case letters 'a' to 'z'
   * for digit values >= 10.
   *
   * @param i
   * @param base
   * @return
   */
  public static String formatUint(ULong i, int base) {
    // Pure java implementation
    final long value = i.longValue();
    /*
     * jOOU doesn't provide toString accepting base/radix
     * This is copy of algorithm from ULong#toString
     * accepting arbitrary base
     * TODO: make PR
     */
    if (value >= 0L)
      return Long.toString(value, base);
    else
      return BigInteger.valueOf(value & Long.MAX_VALUE).add(ULong.MAX_VALUE_LONG).toString(base);
  }

  /**
   * FormatUint returns the string representation of i in the given base,
   * for 2 <= base <= 36. The result uses the lower-case letters 'a' to 'z'
   * for digit values >= 10.
   *
   * @param i
   * @param base
   * @return
   */
  public static String formatUint(UnsignedLong i, int base) {
    // Pure java implementation
    return i.toString(base);
  }

  /**
   * FormatInt returns the string representation of i in the given base,
   * for 2 <= base <= 36. The result uses the lower-case letters 'a' to 'z'
   * for digit values >= 10.
   *
   * @param i
   * @param base
   * @return
   */
  public static String formatInt(long i, int base) {
    // Pure java implementation
    return Long.toString(i, base);
  }

  /**
   * Itoa is shorthand for FormatInt(int64(i), 10).
   */
  public static String itoa(int i) {
    return formatInt(int64(i), 10);
  }

  private StrConv() {}
}
