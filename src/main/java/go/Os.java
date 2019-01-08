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

  /**
   * Getenv retrieves the value of the environment variable named by the key.
   * It returns the value, which will be empty if the variable is not present.
   * To distinguish between an empty value and an unset value, use LookupEnv.
   *
   * @param key
   * @return
   */
  public static String getenv(String key) {
    // testlog.Getenv(key)
    // Pure Java implementation
    String v = System.getenv(key);
    return v == null ? "" : v;
  }

  @Value.Immutable(builder = false)
  public abstract static class LookupEnvResult {
    @Value.Parameter
    public abstract String getValue();
    @Value.Parameter
    public abstract boolean getFound();
  }

  /**
   * LookupEnv retrieves the value of the environment variable named
   * by the key. If the variable is present in the environment the
   * value (which may be empty) is returned and the boolean is true.
   * Otherwise the returned value will be empty and the boolean will
   * be false.
   *
   * @param key
   * @return
   */
  public static LookupEnvResult lookupEnv(String key) {
    // testlog.Getenv(key)
    // Pure Java implementation
    String v = System.getenv(key);
    boolean found = v != null;
    return ImmutableLookupEnvResult.of(found ? v : "", found);
  }

  private Os() {}
}
