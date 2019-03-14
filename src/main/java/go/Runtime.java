/*
 * Java port of Go runtime package
 * Copyright © 2018-2019  Basil Peace
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

import org.apache.commons.lang3.SystemUtils;
import java.util.Locale;

/**
 * Go {@code runtime} package
 */
public final class Runtime {
  /**
   * All supported GOOS values.
   */
  /*
   * Source files:
   * src/go/build/syslist.go
   */
  public enum GoOS {
    AIX,
    ANDROID,
    DARWIN,
    DRAGONFLY,
    FREEBSD,
    HURD,
    /**
     * WebAssembly
     */
    JS,
    LINUX,
    /**
     * Native Client
     */
    NACL,
    NETBSD,
    OPENBSD,
    PLAN9,
    SOLARIS,
    WINDOWS,
    ZOS;

    @Override
    public String toString() {
      return name().toLowerCase(Locale.ROOT);
    }
  }

  // @Lazy
  /**
   * GOOS is the running program's operating system target:
   * one of darwin, freebsd, linux, and so on.
   * To view possible combinations of GOOS and GOARCH, run `go tool dist list`.
   */
  /*
   * Source files:
   * src/runtime/extern.go
   */
  public static final GoOS GOOS;

  static {
    //noinspection IfStatementWithTooManyBranches
    if (SystemUtils.IS_OS_AIX) {
      GOOS = GoOS.AIX;
    } else if (SystemUtils.IS_OS_MAC) {
      GOOS = GoOS.DARWIN;
    } else if (SystemUtils.IS_OS_FREE_BSD) {
      GOOS = GoOS.FREEBSD;
    } else if (SystemUtils.IS_OS_LINUX) {
      GOOS = GoOS.LINUX;
    } else if (SystemUtils.IS_OS_NET_BSD) {
      GOOS = GoOS.NETBSD;
    } else if (SystemUtils.IS_OS_OPEN_BSD) {
      GOOS = GoOS.OPENBSD;
    } else if (SystemUtils.IS_OS_SOLARIS) {
      GOOS = GoOS.SOLARIS;
    } else if (SystemUtils.IS_OS_WINDOWS) {
      GOOS = GoOS.WINDOWS;
    } else if (SystemUtils.IS_OS_ZOS) {
      GOOS = GoOS.ZOS;
    } else {
      // JS and NACL won't be returned since JVM can't run inside these environments (yet)
      // TODO: No way to detect Android, DragonFly, GNU/Hurd, Plan9
      throw new UnsupportedOperationException("Unknown operating system");
    }
  }

  private Runtime() {}
}
