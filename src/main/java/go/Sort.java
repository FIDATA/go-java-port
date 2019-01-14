package go;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public final class Sort {
  // Strings sorts a slice of unicode in increasing order.
  public static void strings(final String[] a) {
    // Pure Java implementation
    Arrays.sort(a);
  }

  /**
   * StringsAreSorted tests whether a slice of unicode is sorted in increasing order.
   *
   * @param a
   * @return
   */
  public static boolean stringsAreSorted(final String[] a) {
    return ArrayUtils.isSorted(a);
  }

  private Sort() {}
}
