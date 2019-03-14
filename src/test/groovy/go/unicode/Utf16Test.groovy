/*
 * Tests for Java port of Go unicode/utf8 package
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
package go.unicode

/*
 * Source files:
 * src/unicode/utf8/utf8_test.go
 */
class Utf16Test {
  /*
type Utf8Map struct {
	r   rune
	str string
}

var utf8map = []Utf8Map{
	{0x0000, "\x00"},
	{0x0001, "\x01"},
	{0x007e, "\x7e"},
	{0x007f, "\x7f"},
	{0x0080, "\xc2\x80"},
	{0x0081, "\xc2\x81"},
	{0x00bf, "\xc2\xbf"},
	{0x00c0, "\xc3\x80"},
	{0x00c1, "\xc3\x81"},
	{0x00c8, "\xc3\x88"},
	{0x00d0, "\xc3\x90"},
	{0x00e0, "\xc3\xa0"},
	{0x00f0, "\xc3\xb0"},
	{0x00f8, "\xc3\xb8"},
	{0x00ff, "\xc3\xbf"},
	{0x0100, "\xc4\x80"},
	{0x07ff, "\xdf\xbf"},
	{0x0400, "\xd0\x80"},
	{0x0800, "\xe0\xa0\x80"},
	{0x0801, "\xe0\xa0\x81"},
	{0x1000, "\xe1\x80\x80"},
	{0xd000, "\xed\x80\x80"},
	{0xd7ff, "\xed\x9f\xbf"}, // last code point before surrogate half.
	{0xe000, "\xee\x80\x80"}, // first code point after surrogate half.
	{0xfffe, "\xef\xbf\xbe"},
	{0xffff, "\xef\xbf\xbf"},
	{0x10000, "\xf0\x90\x80\x80"},
	{0x10001, "\xf0\x90\x80\x81"},
	{0x40000, "\xf1\x80\x80\x80"},
	{0x10fffe, "\xf4\x8f\xbf\xbe"},
	{0x10ffff, "\xf4\x8f\xbf\xbf"},
	{0xFFFD, "\xef\xbf\xbd"},
}

var surrogateMap = []Utf8Map{
	{0xd800, "\xed\xa0\x80"}, // surrogate min decodes to (RuneError, 1)
	{0xdfff, "\xed\xbf\xbf"}, // surrogate max decodes to (RuneError, 1)
}

var testStrings = []string{
	"",
	"abcd",
	"☺☻☹",
	"日a本b語ç日ð本Ê語þ日¥本¼語i日©",
	"日a本b語ç日ð本Ê語þ日¥本¼語i日©日a本b語ç日ð本Ê語þ日¥本¼語i日©日a本b語ç日ð本Ê語þ日¥本¼語i日©",
	"\x80\x80\x80\x80",
}

func TestDecodeRune(t *testing.T) {
	for _, m := range utf8map {
		b := []byte(m.str)
		r, size := DecodeRune(b)
		if r != m.r || size != len(b) {
			t.Errorf("DecodeRune(%q) = %#04x, %d want %#04x, %d", b, r, size, m.r, len(b))
		}
		s := m.str
		r, size = DecodeRuneInString(s)
		if r != m.r || size != len(b) {
			t.Errorf("DecodeRuneInString(%q) = %#04x, %d want %#04x, %d", s, r, size, m.r, len(b))
		}

		// there's an extra byte that bytes left behind - make sure trailing byte works
		r, size = DecodeRune(b[0:cap(b)])
		if r != m.r || size != len(b) {
			t.Errorf("DecodeRune(%q) = %#04x, %d want %#04x, %d", b, r, size, m.r, len(b))
		}
		s = m.str + "\x00"
		r, size = DecodeRuneInString(s)
		if r != m.r || size != len(b) {
			t.Errorf("DecodeRuneInString(%q) = %#04x, %d want %#04x, %d", s, r, size, m.r, len(b))
		}

		// make sure missing bytes fail
		wantsize := 1
		if wantsize >= len(b) {
			wantsize = 0
		}
		r, size = DecodeRune(b[0 : len(b)-1])
		if r != RuneError || size != wantsize {
			t.Errorf("DecodeRune(%q) = %#04x, %d want %#04x, %d", b[0:len(b)-1], r, size, RuneError, wantsize)
		}
		s = m.str[0 : len(m.str)-1]
		r, size = DecodeRuneInString(s)
		if r != RuneError || size != wantsize {
			t.Errorf("DecodeRuneInString(%q) = %#04x, %d want %#04x, %d", s, r, size, RuneError, wantsize)
		}

		// make sure bad sequences fail
		if len(b) == 1 {
			b[0] = 0x80
		} else {
			b[len(b)-1] = 0x7F
		}
		r, size = DecodeRune(b)
		if r != RuneError || size != 1 {
			t.Errorf("DecodeRune(%q) = %#04x, %d want %#04x, %d", b, r, size, RuneError, 1)
		}
		s = string(b)
		r, size = DecodeRuneInString(s)
		if r != RuneError || size != 1 {
			t.Errorf("DecodeRuneInString(%q) = %#04x, %d want %#04x, %d", s, r, size, RuneError, 1)
		}

	}
}

func TestDecodeSurrogateRune(t *testing.T) {
	for _, m := range surrogateMap {
		b := []byte(m.str)
		r, size := DecodeRune(b)
		if r != RuneError || size != 1 {
			t.Errorf("DecodeRune(%q) = %x, %d want %x, %d", b, r, size, RuneError, 1)
		}
		s := m.str
		r, size = DecodeRuneInString(s)
		if r != RuneError || size != 1 {
			t.Errorf("DecodeRuneInString(%q) = %x, %d want %x, %d", b, r, size, RuneError, 1)
		}
	}
}

// Check that DecodeRune and DecodeLastRune correspond to
// the equivalent range loop.
func TestSequencing(t *testing.T) {
	for _, ts := range testStrings {
		for _, m := range utf8map {
			for _, s := range []string{ts + m.str, m.str + ts, ts + m.str + ts} {
				testSequence(t, s)
			}
		}
	}
}

var invalidSequenceTests = []string{
	"\xed\xa0\x80\x80", // surrogate min
	"\xed\xbf\xbf\x80", // surrogate max

	// xx
	"\x91\x80\x80\x80",

	// s1
	"\xC2\x7F\x80\x80",
	"\xC2\xC0\x80\x80",
	"\xDF\x7F\x80\x80",
	"\xDF\xC0\x80\x80",

	// s2
	"\xE0\x9F\xBF\x80",
	"\xE0\xA0\x7F\x80",
	"\xE0\xBF\xC0\x80",
	"\xE0\xC0\x80\x80",

	// s3
	"\xE1\x7F\xBF\x80",
	"\xE1\x80\x7F\x80",
	"\xE1\xBF\xC0\x80",
	"\xE1\xC0\x80\x80",

	//s4
	"\xED\x7F\xBF\x80",
	"\xED\x80\x7F\x80",
	"\xED\x9F\xC0\x80",
	"\xED\xA0\x80\x80",

	// s5
	"\xF0\x8F\xBF\xBF",
	"\xF0\x90\x7F\xBF",
	"\xF0\x90\x80\x7F",
	"\xF0\xBF\xBF\xC0",
	"\xF0\xBF\xC0\x80",
	"\xF0\xC0\x80\x80",

	// s6
	"\xF1\x7F\xBF\xBF",
	"\xF1\x80\x7F\xBF",
	"\xF1\x80\x80\x7F",
	"\xF1\xBF\xBF\xC0",
	"\xF1\xBF\xC0\x80",
	"\xF1\xC0\x80\x80",

	// s7
	"\xF4\x7F\xBF\xBF",
	"\xF4\x80\x7F\xBF",
	"\xF4\x80\x80\x7F",
	"\xF4\x8F\xBF\xC0",
	"\xF4\x8F\xC0\x80",
	"\xF4\x90\x80\x80",
}

func TestDecodeInvalidSequence(t *testing.T) {
	for _, s := range invalidSequenceTests {
		r1, _ := DecodeRune([]byte(s))
		if want := RuneError; r1 != want {
			t.Errorf("DecodeRune(%#x) = %#04x, want %#04x", s, r1, want)
			return
		}
		r2, _ := DecodeRuneInString(s)
		if want := RuneError; r2 != want {
			t.Errorf("DecodeRuneInString(%q) = %#04x, want %#04x", s, r2, want)
			return
		}
		if r1 != r2 {
			t.Errorf("DecodeRune(%#x) = %#04x mismatch with DecodeRuneInString(%q) = %#04x", s, r1, s, r2)
			return
		}
		r3 := runtimeDecodeRune(s)
		if r2 != r3 {
			t.Errorf("DecodeRuneInString(%q) = %#04x mismatch with runtime.decoderune(%q) = %#04x", s, r2, s, r3)
			return
		}
	}
}

func testSequence(t *testing.T, s string) {
	type info struct {
		index int
		r     rune
	}
	index := make([]info, len(s))
	b := []byte(s)
	si := 0
	j := 0
	for i, r := range s {
		if si != i {
			t.Errorf("Sequence(%q) mismatched index %d, want %d", s, si, i)
			return
		}
		index[j] = info{i, r}
		j++
		r1, size1 := DecodeRune(b[i:])
		if r != r1 {
			t.Errorf("DecodeRune(%q) = %#04x, want %#04x", s[i:], r1, r)
			return
		}
		r2, size2 := DecodeRuneInString(s[i:])
		if r != r2 {
			t.Errorf("DecodeRuneInString(%q) = %#04x, want %#04x", s[i:], r2, r)
			return
		}
		if size1 != size2 {
			t.Errorf("DecodeRune/DecodeRuneInString(%q) size mismatch %d/%d", s[i:], size1, size2)
			return
		}
		si += size1
	}
	j--
	for si = len(s); si > 0; {
		r1, size1 := DecodeLastRune(b[0:si])
		r2, size2 := DecodeLastRuneInString(s[0:si])
		if size1 != size2 {
			t.Errorf("DecodeLastRune/DecodeLastRuneInString(%q, %d) size mismatch %d/%d", s, si, size1, size2)
			return
		}
		if r1 != index[j].r {
			t.Errorf("DecodeLastRune(%q, %d) = %#04x, want %#04x", s, si, r1, index[j].r)
			return
		}
		if r2 != index[j].r {
			t.Errorf("DecodeLastRuneInString(%q, %d) = %#04x, want %#04x", s, si, r2, index[j].r)
			return
		}
		si -= size1
		if si != index[j].index {
			t.Errorf("DecodeLastRune(%q) index mismatch at %d, want %d", s, si, index[j].index)
			return
		}
		j--
	}
	if si != 0 {
		t.Errorf("DecodeLastRune(%q) finished at %d, not 0", s, si)
	}
}
   */
}
