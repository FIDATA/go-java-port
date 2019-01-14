package go;

import static go.Runtime.GoOS.*;
import org.immutables.value.Value;

public final class Os {
  public static final char PATH_SEPARATOR = Runtime.GOOS == WINDOWS ? '\\' : '/';

  /**
   * IsPathSeparator reports whether c is a directory separator character.
   * @param c
   * @return
   */
  public static boolean isPathSeparator(char c) {
    // NOTE: Windows accept / as path separator.
    return Runtime.GOOS == WINDOWS ? c == '\\' || c == '/' : PATH_SEPARATOR == c;
  }

  private Os() {}
}
