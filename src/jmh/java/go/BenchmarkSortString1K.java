package go;

import static go.Builtin.*;
import static go.Sort.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class BenchmarkSortString1K {
  private static final int UNSORTED_LEN = 1 << 10;

  @State(Scope.Benchmark)
  public static /*final*/ class BenchmarkSortString1KBenchmarkState {
    private final String[] unsorted;
    public BenchmarkSortString1KBenchmarkState() {
      unsorted = make(String.class, UNSORTED_LEN);
      for (int i = 0; i < UNSORTED_LEN; i++) {
        unsorted[i] = StrConv.itoa(i ^ 0x2cc);
      }
    }
  }

  private final String[] data;

  public BenchmarkSortString1K() {
    data = make(String.class, UNSORTED_LEN);
  }

  @Setup(Level.Iteration)
  public void setup(BenchmarkSortString1KBenchmarkState benchmarkState) {
    copy(data, benchmarkState.unsorted);
  }

  @Benchmark
  public void benchmarkSortString1K(Blackhole blackhole) {
    strings(data);
    blackhole.consume(data);
  }
}
