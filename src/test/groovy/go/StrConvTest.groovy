package go

import com.google.common.primitives.UnsignedLong
import org.joou.ULong
import static go.StrConv.*
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner)
final class StrConvTest {
  static Object[] itob64tests() {
    [
      [0, 10, '0'],
      [1, 10, '1'],
      [-1, 10, '-1'],
      [12345678, 10, '12345678'],
      [-987654321, 10, '-987654321'],
      [1 << 31 - 1, 10, '2147483647'],
      [-1 << 31 + 1, 10, '-2147483647'],
      [1 << 31, 10, '2147483648'],
      [-1 << 31, 10, '-2147483648'],
      [1 << 31 + 1, 10, '2147483649'],
      [-1 << 31 - 1, 10, '-2147483649'],
      [1 << 32 - 1, 10, '4294967295'],
      [-1 << 32 + 1, 10, '-4294967295'],
      [1 << 32, 10, '4294967296'],
      [-1 << 32, 10, '-4294967296'],
      [1 << 32 + 1, 10, '4294967297'],
      [-1 << 32 - 1, 10, '-4294967297'],
      [1 << 50, 10, '1125899906842624'],
      [1 << 63 - 1, 10, '9223372036854775807'],
      [-1 << 63 + 1, 10, '-9223372036854775807'],
      [-1 << 63, 10, '-9223372036854775808'],

      [0, 2, '0'],
      [10, 2, '1010'],
      [-1, 2, '-1'],
      [1 << 15, 2, '1000000000000000'],

      [-8, 8, '-10'],
      [057635436545L, 8, '57635436545'],
      [1 << 24, 8, '100000000'],

      [16, 16, '10'],
      [-0x123456789abcdefL, 16, '-123456789abcdef'],
      [1 << 63 - 1, 16, '7fffffffffffffff'],
      [1 << 63 - 1, 2, '111111111111111111111111111111111111111111111111111111111111111'],
      [-1 << 63, 2, '-1000000000000000000000000000000000000000000000000000000000000000'],

      [16, 17, 'g'],
      [25, 25, '10'],
      [(((((17 * 35 + 24) * 35 + 21) * 35 + 34) * 35 + 12) * 35 + 24) * 35 + 32, 35, 'holycow'],
      [(((((17 * 36 + 24) * 36 + 21) * 36 + 34) * 36 + 12) * 36 + 24) * 36 + 32, 36, 'holycow'],
    ].collect { it.toArray(new Object[3]) }.toArray()
  }

  @Test
  @Parameters(method = 'itob64tests')
  void testItoa(long aIn, int base, String out) {
    String s
    s = formatInt(aIn, base)
    assert s == out :
      // TODO: Port fmt
      // t.Errorf('FormatInt(%v, %v) = %v want %v',
      //  test.in, test.base, s, test.out)
      sprintf('FormatInt(%d, %d) = %s want %s',
        aIn, base, s, out)

    if (aIn >= 0) {
      s = formatUint(UnsignedLong.valueOf(aIn), base)
      assert s == out :
        /*t.Errorf('FormatUint(%v, %v) = %v want %v',
          test.in, test.base, s, test.out)*/
        sprintf('FormatUint((UnsignedLong)%d, %d) = %s want %s',
          aIn, base, s, out)

      s = formatUint(ULong.valueOf(aIn), base)
      assert s == out :
        /*t.Errorf('FormatUint(%v, %v) = %v want %v',
            test.in, test.base, s, test.out)*/
        sprintf('FormatUint((ULong)%d, %d) = %s want %s',
          aIn, base, s, out)
    }

    if (base == 10 && ((long)(int)(aIn)) == aIn) {
      s = itoa((int)test.in)
      assert s == out :
        /*t.Errorf('Itoa(%v) = %v want %v',
            test.in, s, test.out)*/
        sprintf('Itoa(%d) = %s want %s',
          aIn, s, out)
    }
  }

  static Object[] uitob64tests() {
    [
      [BigInteger.valueOf(1L).shiftLeft(63).minus(1), 10, '9223372036854775807'],
      [BigInteger.valueOf(1L).shiftLeft(63), 10, '9223372036854775808'],
      [BigInteger.valueOf(1L).shiftLeft(63).plus(1), 10, '9223372036854775809'],
      [BigInteger.valueOf(1L).shiftLeft(64).minus(2), 10, '18446744073709551614'],
      [BigInteger.valueOf(1L).shiftLeft(64).minus(1), 10, '18446744073709551615'],
      [BigInteger.valueOf(1L).shiftLeft(64).minus(1), 2, '1111111111111111111111111111111111111111111111111111111111111111'],
    ].collect { it.toArray(new Object[3]) }.toArray()
  }

  @Test
  @Parameters(method = 'uitob64tests')
  void TestUitoa(BigInteger aIn, int base, String out) {
    String s

    s = formatUint(UnsignedLong.valueOf(aIn), base)
    assert s == out :
      /*t.Errorf('FormatUint(%v, %v) = %v want %v',
        test.in, test.base, s, test.out)*/
      sprintf('FormatUint((UnsignedLong)%d, %d) = %s want %s',
        aIn, base, s, out)

    s = formatUint(ULong.valueOf(aIn), base)
    assert s == out :
      /*t.Errorf('FormatUint(%v, %v) = %v want %v',
        test.in, test.base, s, test.out)*/
      sprintf('FormatUint((ULong)%d, %d) = %s want %s',
        aIn, base, s, out)
  }
  
  Object[] varlenUints() {
    // Original Go test contains predefined Strings.
    // We generate the same values, but programmatically,
    // to avoid construction of BigIntegers from string
    // which is the exact reversion of what we are testing
    final Object[] result = new Object[20]
    BigInteger aIn = BigInteger.ZERO
    String out = ''
    int index = 0
    for (int j in 0..1) {
      for (int i in 1..10) {
        final int digit = i % 10
        aIn = aIn.multiply(10).plus(digit)
        out += digit.toString()
        result[index] = [aIn, out].toArray(new Object[2])
      }
    }
    result
  }

  @Test
  @Parameters(method = 'varlenUints')
  void testFormatUintVarlen(BigInteger aIn, String out) {
    String s

    s = formatUint(UnsignedLong.valueOf(aIn), 10)
    assert s == out :
      /*t.Errorf('FormatUint(%v, 10) = %v want %v',
        test.in, test.base, s, test.out)*/
      sprintf('FormatUint((UnsignedLong)%d, 10) = %s want %s',
        aIn, base, s, out)

    s = formatUint(ULong.valueOf(aIn), 10)
    assert s == out :
      /*t.Errorf('FormatUint(%v, 10) = %v want %v',
        test.in, test.base, s, test.out)*/
      sprintf('FormatUint((ULong)%d, 10) = %s want %s',
        aIn, base, s, out)
  }
}
