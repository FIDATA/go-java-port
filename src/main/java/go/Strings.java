/*
 * Java port of Go strings package
 * Copyright © 2019  Basil Peace
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

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Package {@code strings} implements simple functions to manipulate UTF-16 encoded strings.
 */
/*
 * Source files:
 * src/strings/strings.go
 */
public final class Strings {
  /**
   * Join concatenates the elements of a to create a single string. The separator string
   * sep is placed between elements in the resulting string.
   */
  /*
   * Source files:
   * src/strings/strings.go
   */
  public static String join(String[] a, String sep) {
    return join(a, 0, sep);
  }

  /**
   * Join concatenates the elements of a to create a single string. The separator string
   * sep is placed between elements in the resulting string.
   */
  /*
   * Source files:
   * src/strings/strings.go
   */
  public static String join(String[] a, int start, String sep) {
    return join(a, start, a.length, sep);
  }

  /**
   * Join concatenates the elements of a to create a single string. The separator string
   * sep is placed between elements in the resulting string.
   */
  /*
   * Source files:
   * src/strings/strings.go
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
