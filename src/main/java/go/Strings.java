package go;

import static go.Builtin.*;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.StringJoiner;

public final class Strings {
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

  private Strings() {}
}
