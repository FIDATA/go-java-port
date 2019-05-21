/*
 * Benchmark for Java port of Go strings.join func
 * Copyright ©  Basil Peace
 * Copyright 2009 The Go Authors. All rights reserved.
 *
 * This file is part of go-java-port.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Basil Peace designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Basil Peace in the LICENSE file that accompanied this code.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package go;

import static go.Strings.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

/*
 * Source files:
 * src/strings/strings_test.go
 */
@State(Scope.Benchmark)
public final class BenchmarkStringsJoin {
  private static final String[] VALS = {"red", "yellow", "pink", "green", "purple", "orange", "blue"};

  private String[] vals;

  @Param({"0", "1", "2", "3", "4", "5", "6", "7"})
  public int l;

  @Setup(Level.Trial)
  public void setup() {
    vals = new String[l];
    System.arraycopy(VALS, 0, vals, 0, l);
  }

  @Benchmark
  public void benchmarkJoin(Blackhole blackhole) {
    blackhole.consume(join(vals, " and "));
  }
}
