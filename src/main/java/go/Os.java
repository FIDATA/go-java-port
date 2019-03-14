/*
 * Java port of Go os package
 * Copyright © 2019  Basil Peace
 * Copyright 2009, 2011 The Go Authors. All rights reserved.
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

import static go.Runtime.GoOS.*;

/**
 * Package {@code os} provides a platform-independent interface to operating system
 * functionality.
 *
 * The {@code os} interface is intended to be uniform across all operating systems.
 */
/* Source files:
 * src/os/file.go
 */
public final class Os {
  /**
   * OS-specific path separator
   */
  /* Source files:
   * src/os/path_plan9.go
   * src/os/path_unix.go
   * src/os/path_windows.go
   */
  public static final char PATH_SEPARATOR = Runtime.GOOS == WINDOWS ? '\\' : '/';

  /**
   * IsPathSeparator reports whether {@code c} is a directory separator character.
   * @param c
   * @return
   */
  /* Source files:
   * src/os/path_plan9.go
   * src/os/path_unix.go
   * src/os/path_windows.go
   */
  public static boolean isPathSeparator(char c) {
    // NOTE: Windows accept / as path separator.
    return Runtime.GOOS == WINDOWS ? c == '\\' || c == '/' : PATH_SEPARATOR == c;
  }

  private Os() {}
}
