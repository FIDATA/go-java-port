package go

import groovy.transform.CompileStatic
import org.junit.Test
import static Sort.*

@CompileStatic
final class SortTest {
  private static final String[] STRINGS = ["", "Hello", "foo", "bar", "foo", "f00", "%*&^*&^&", "***"]

  @Test
  void testStrings() {
    String[] data = STRINGS
    strings(data)
    assert stringsAreSorted(data) :
      /*
       * CAVEAT:
       * STRINGS initially are not sorted.
       * Go reports something wrong here.
       * <grv87 2019-01-09>
       */
      // TODO: Port fmt.Sprintf to use %v
      sprintf("sorted %s", STRINGS.toString()) + "\n" +
      sprintf("   got %s", data.toString())
  }
}
