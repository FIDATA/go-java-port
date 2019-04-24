#!/usr/bin/env groovy
/*
 * Tests for Java port of Go path/filepath package
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
package go.path

import static go.Runtime.GoOS.*
import static go.path.FilePath.*
import org.junit.rules.ExpectedException
import groovy.transform.CompileStatic
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.EnvironmentVariables
import org.junit.runner.RunWith
import go.Runtime

@RunWith(JUnitParamsRunner)
@CompileStatic
class FilePathTest {
  /*
   * WORKAROUND:
   * Otherwise we have error:
   * initializationError
   * org.junit.internal.runners.rules.ValidationError: The @Rule 'thrown' must be public.
   * <grv87 2019-01-15>
   */
  @Rule
  @SuppressWarnings('PublicInstanceField')
  public final ExpectedException thrown = ExpectedException.none()
  @Rule
  @SuppressWarnings('PublicInstanceField')
  public final EnvironmentVariables environmentVariables = new EnvironmentVariables()

  private static Object[] cleantests() {
    [
      // Already clean
      ['abc', 'abc'],
      ['abc/def', 'abc/def'],
      ['a/b/c', 'a/b/c'],
      ['.', '.'],
      ['..', '..'],
      ['../..', '../..'],
      ['../../abc', '../../abc'],
      ['/abc', '/abc'],
      ['/', '/'],
  
      // Empty is current dir
      ['', '.'],
  
      // Remove trailing slash
      ['abc/', 'abc'],
      ['abc/def/', 'abc/def'],
      ['a/b/c/', 'a/b/c'],
      ['./', '.'],
      ['../', '..'],
      ['../../', '../..'],
      ['/abc/', '/abc'],
  
      // Remove doubled slash
      ['abc//def//ghi', 'abc/def/ghi'],
      ['//abc', '/abc'],
      ['///abc', '/abc'],
      ['//abc//', '/abc'],
      ['abc//', 'abc'],
  
      // Remove . elements
      ['abc/./def', 'abc/def'],
      ['/./abc/def', '/abc/def'],
      ['abc/.', 'abc'],
  
      // Remove .. elements
      ['abc/def/ghi/../jkl', 'abc/def/jkl'],
      ['abc/def/../ghi/../jkl', 'abc/jkl'],
      ['abc/def/..', 'abc'],
      ['abc/def/../..', '.'],
      ['/abc/def/../..', '/'],
      ['abc/def/../../..', '..'],
      ['/abc/def/../../..', '/'],
      ['abc/def/../../../ghi/jkl/../../../mno', '../../mno'],
      ['/../abc', '/abc'],
  
      // Combinations
      ['abc/./../def', 'def'],
      ['abc//./../def', 'def'],
      ['abc/../../././../def', '../../def'],
    ].collect { it.toArray(new Object[2]) }.toArray()
  }

  private static Object[] wincleantests() {
    [
      ['c:', 'c:.'],
      ['c:\\', 'c:\\'],
      ['c:\\abc', 'c:\\abc'],
      ['c:abc\\..\\..\\.\\.\\..\\def', 'c:..\\..\\def'],
      ['c:\\abc\\def\\..\\..', 'c:\\'],
      ['c:\\..\\abc', 'c:\\abc'],
      ['c:..\\abc', 'c:..\\abc'],
      ['\\', '\\'],
      ['/', '\\'],
      ['\\\\i\\..\\c$', '\\c$'],
      ['\\\\i\\..\\i\\c$', '\\i\\c$'],
      ['\\\\i\\..\\I\\c$', '\\I\\c$'],
      ['\\\\host\\share\\foo\\..\\bar', '\\\\host\\share\\bar'],
      ['//host/share/foo/../baz', '\\\\host\\share\\baz'],
      ['\\\\a\\b\\..\\c', '\\\\a\\b\\c'],
      ['\\\\a\\b', '\\\\a\\b'],
    ].collect { it.toArray(new Object[2]) }.toArray()
  }

  @Test
  @Parameters(method = 'cleantests')
  void testClean(String path, String result) {
    if (Runtime.GOOS == WINDOWS) {
      result = fromSlash(result)
    }
    String s
    s = clean(path)
    assert s == result :
      sprintf("Clean(%s) = %s, want %s", path, s, result)
    s = clean(result)
    assert s == result :
      sprintf("Clean(%s) = %s, want %s", result, s, result)
  }

  @Test
  @Parameters(method = 'wincleantests')
  void testCleanWindows(String path, String result) {
    environmentVariables.set('os.name', 'Windows Fiction')
    testClean path, result
  }

  /*private static Object[] os() {
    [
      'Windows Fiction',
      'Linux Generic',
    ].toArray()
  }*/

  private static Object[] slashtests() {
    /*
     * CAVEAT:
     * Go runs Windows tests only if current runtime is Windows.
     * This has a drawback that cases should be run
     * We cheat OS detection and make it think we are under Windows.
     * <grv87 2018-01-15>
     */
    final char sep = SEPARATOR
    [
      ['', ''],
      ['/', Character.toString(sep)],
      ['/a/b', "${ sep }a${ sep }b".toString()],
      ['a//b', "a${ sep }${ sep }b".toString()],
    ].collect { it.toArray(new Object[2]) }.toArray()
  }

  @Test
  @Parameters(method = 'slashtests')
  void testFromAndToSlash(String path, String result) {
    String s
    s = fromSlash(path)
    assert s == result :
      sprintf('FromSlash(%s) = %s, want %s', path, s, result)
    s = toSlash(result)
    assert s == path :
      sprintf('ToSlash(%s) = %s, want %s', result, s, path)
  }

  private static Object[] unixsplittests() {
    [
      ['a/b', 'a/', 'b'],
      ['a/b/', 'a/b/', ''],
      ['a/', 'a/', ''],
      ['a', '', 'a'],
      ['/', '/', ''],
    ].collect { it.toArray(new Object[3]) }.toArray()
  }

  private static Object[] winsplittests() {
    [
      ['c:', 'c:', ''],
      ['c:/', 'c:/', ''],
      ['c:/foo', 'c:/', 'foo'],
      ['c:/foo/bar', 'c:/foo/', 'bar'],
      ['//host/share', '//host/share', ''],
      ['//host/share/', '//host/share/', ''],
      ['//host/share/foo', '//host/share/', 'foo'],
      ['\\\\host\\share', '\\\\host\\share', ''],
      ['\\\\host\\share\\', '\\\\host\\share\\', ''],
      ['\\\\host\\share\\foo', '\\\\host\\share\\', 'foo'],
    ].collect { it.toArray(new Object[3]) }.toArray()
  }

  @Test
  @Parameters(method = 'unixsplittests')
  void testSplit(String path, String dir, String file) {
    SplitResult splitResult = split(path)
    String d = splitResult.dir
    String f = splitResult.file
    assert d == dir && f == file :
      sprintf('Split(%s) = %s, %s, want %s, %s', path, d, f, dir, file)
  }

  @Test
  @Parameters(method = 'winsplittests')
  void testSplitWindows(String path, String dir, String file) {
    environmentVariables.set('os.name', 'Windows Fiction')
    testSplit path, dir, file
  }

  private static Object[] jointests() {
    [
      // zero parameters
      [[], ''],

      // one parameter
      [[''], ''],
      [['/'], '/'],
      [['a'], 'a'],

      // two parameters
      [['a', 'b'], 'a/b'],
      [['a', ''], 'a'],
      [['', 'b'], 'b'],
      [['/', 'a'], '/a'],
      [['/', 'a/b'], '/a/b'],
      [['/', ''], '/'],
      [['//', 'a'], '/a'],
      [['/a', 'b'], '/a/b'],
      [['a/', 'b'], 'a/b'],
      [['a/', ''], 'a'],
      [['', ''], ''],

      // three parameters
      [['/', 'a', 'b'], '/a/b'],
    ].collect { it.toArray(new Object[2]) }.toArray()
  }

  private static Object[] winjointests() {
    [
      [['directory', 'file'], 'directory\\file'],
      [['C:\\Windows\\', 'System32'], 'C:\\Windows\\System32'],
      [['C:\\Windows\\', ''], 'C:\\Windows'],
      [['C:\\', 'Windows'], 'C:\\Windows'],
      [['C:', 'a'], 'C:a'],
      [['C:', 'a\\b'], 'C:a\\b'],
      [['C:', 'a', 'b'], 'C:a\\b'],
      [['C:.', 'a'], 'C:a'],
      [['C:a', 'b'], 'C:a\\b'],
      [['C:a', 'b', 'd'], 'C:a\\b\\d'],
      [['\\\\host\\share', 'foo'], '\\\\host\\share\\foo'],
      [['\\\\host\\share\\foo'], '\\\\host\\share\\foo'],
      [['//host/share', 'foo/bar'], '\\\\host\\share\\foo\\bar'],
      [['\\'], '\\'],
      [['\\', ''], '\\'],
      [['\\', 'a'], '\\a'],
      [['\\\\', 'a'], '\\a'],
      [['\\', 'a', 'b'], '\\a\\b'],
      [['\\\\', 'a', 'b'], '\\a\\b'],
      [['\\', '\\\\a\\b', 'c'], '\\a\\b\\c'],
      [['\\\\a', 'b', 'c'], '\\a\\b\\c'],
      [['\\\\a\\', 'b', 'c'], '\\a\\b\\c'],
    ].collect { it.toArray(new Object[2]) }.toArray()
  }

  @Test
  @Parameters(method = 'jointests')
  void testJoin(List<String> elem, String path) {
    String expected = fromSlash(path)
    String p = join(elem.toArray(new String[0]))
    assert p == expected :
      sprintf('join(%s) = %s, want %s', elem, p, expected)
  }

  @Test
  @Parameters(method = 'winjointests')
  void testJoinWindows(List<String> elem, String path) {
    environmentVariables.set('os.name', 'Windows Fiction')
    testJoin elem, path
  }

  // Windows only
  @Test
  void testUNC() {
    // Test that this doesn't go into an infinite recursion.
    // See golang.org/issue/15879.
    glob('\\\\?\\c:\\*')
  }

  private static Object[] matchTests() {
    [
      ['abc', 'abc', true, null],
      ['*', 'abc', true, null],
      ['*c', 'abc', true, null],
      ['a*', 'a', true, null],
      ['a*', 'abc', true, null],
      ['a*', 'ab/c', false, null],
      ['a*/b', 'abc/b', true, null],
      ['a*/b', 'a/c/b', false, null],
      ['a*b*c*d*e*/f', 'axbxcxdxe/f', true, null],
      ['a*b*c*d*e*/f', 'axbxcxdxexxx/f', true, null],
      ['a*b*c*d*e*/f', 'axbxcxdxe/xxx/f', false, null],
      ['a*b*c*d*e*/f', 'axbxcxdxexxx/fff', false, null],
      ['a*b?c*x', 'abxbbxdbxebxczzx', true, null],
      ['a*b?c*x', 'abxbbxdbxebxczzy', false, null],
      ['ab[c]', 'abc', true, null],
      ['ab[b-d]', 'abc', true, null],
      ['ab[e-g]', 'abc', false, null],
      ['ab[^c]', 'abc', false, null],
      ['ab[^b-d]', 'abc', false, null],
      ['ab[^e-g]', 'abc', true, null],
      ['a\\*b', 'a*b', true, null],
      ['a\\*b', 'ab', false, null],
      ['a?b', 'a☺b', true, null],
      ['a[^a]b', 'a☺b', true, null],
      ['a???b', 'a☺b', false, null],
      ['a[^a][^a][^a]b', 'a☺b', false, null],
      ['[a-ζ]*', 'α', true, null],
      ['*[a-ζ]', 'A', false, null],
      ['a?b', 'a/b', false, null],
      ['a*b', 'a/b', false, null],
      ['[\\]a]', ']', true, null],
      ['[\\-]', '-', true, null],
      ['[x\\-]', 'x', true, null],
      ['[x\\-]', '-', true, null],
      ['[x\\-]', 'z', false, null],
      ['[\\-x]', 'x', true, null],
      ['[\\-x]', '-', true, null],
      ['[\\-x]', 'a', false, null],
      ['[]a]', ']', false, ErrBadPattern],
      ['[-]', '-', false, ErrBadPattern],
      ['[x-]', 'x', false, ErrBadPattern],
      ['[x-]', '-', false, ErrBadPattern],
      ['[x-]', 'z', false, ErrBadPattern],
      ['[-x]', 'x', false, ErrBadPattern],
      ['[-x]', '-', false, ErrBadPattern],
      ['[-x]', 'a', false, ErrBadPattern],
      ['\\', 'a', false, ErrBadPattern],
      ['[a-b-c]', 'a', false, ErrBadPattern],
      ['[', 'a', false, ErrBadPattern],
      ['[^', 'a', false, ErrBadPattern],
      ['[^bc', 'a', false, ErrBadPattern],
      ['a[', 'a', false, null],
      ['a[', 'ab', false, ErrBadPattern],
      ['*x', 'xxx', true, null],
    ].collect { it.toArray(new Object[4]) }.toArray()
  }

  @Test
  @Parameters(method = 'matchTests')
  void testMatch(String pattern, String s, boolean aMatch, Class<? extends Exception> err) {
    if (Runtime.GOOS == WINDOWS) {
      if (pattern.contains("\\")) {
        // no escape allowed on windows.
        return
      }
      pattern = clean(pattern)
      s = clean(s)
    }
    if (err != null) {
      thrown.expect(err)
      // TODO: format Match(%#q, %#q) throws %%s want %s
      thrown.reportMissingExceptionWithMessage(sprintf('Match(%s, %s) throws %%s want %s', pattern.inspect(), s.inspect(), err))
    }
    boolean ok = match(pattern, s)
    assert ok == aMatch :
      // TODO: format Match(%#q, %#q) = %v want %v
      sprintf('Match(%s, %s) = %s want %s', pattern.inspect(), s.inspect(), ok, aMatch)
  }

/*// contains returns true if vector contains the string s.
                  func contains(vector []string, s string) bool {
                    for _, elem := range vector {
                      if elem == s {
                        return true
                      }
                    }
                    return false
                  }*/

  private static Object[] globTests() {
    [
      [ 'match.go', 'match.go' ],
      [ 'mat?h.go', 'match.go' ],
      [ '*', 'match.go' ],
      [ '../*/match.go', '../filepath/match.go'],
    ].collect { it.toArray(new Object[2]) }.toArray()
  }

//  @Test
//  @Parameters(method = 'globTests')
//  void testGlob(String pattern, String result) {
//    if (Runtime.GOOS == WINDOWS) {
//      pattern = clean(pattern)
//      result = clean(result)
//    }
//    List<String> matches = glob(pattern)
//    assert matches.find { it == result } :
//      sprintf("Glob(%#q) = %#v want %v", pattern, matches, result)
//
//    for _, pattern := range []string{"no_match", "../*/no_match"} {
//      matches, err := Glob(pattern)
//      if err != nil {
//        t.Errorf("Glob error for %q: %s", pattern, err)
//        continue
//      }
//      if len(matches) != 0 {
//        t.Errorf("Glob(%#q) = %#v want []", pattern, matches)
//      }
//    }
//  }

  @Test
  void testGlobError() {
    thrown.expect(ErrBadPattern)
    thrown.reportMissingExceptionWithMessage('expected error for bad pattern; got none')
    glob('[]')
  }

  @Test
  void testGlobUNC() {
    // Just make sure this runs without crashing for now.
    // See issue 15879.
    glob('\\\\?\\C:\\*')
  }

//                  var globSymlinkTests = []struct {
//                    path, dest string
//                    brokenLink bool
//                  }{
//                    {"test1", "link1", false},
//                    {"test2", "link2", true},
//                  }
//
//                  func TestGlobSymlink(t *testing.T) {
//                    testenv.MustHaveSymlink(t)
//
//                    tmpDir, err := ioutil.TempDir("", "globsymlink")
//                    if err != nil {
//                      t.Fatal("creating temp dir:", err)
//                    }
//                    defer os.RemoveAll(tmpDir)
//
//                    for _, tt := range globSymlinkTests {
//                      path := Join(tmpDir, tt.path)
//                      dest := Join(tmpDir, tt.dest)
//                      f, err := os.Create(path)
//                      if err != nil {
//                        t.Fatal(err)
//                      }
//                      if err := f.Close(); err != nil {
//                        t.Fatal(err)
//                      }
//                      err = os.Symlink(path, dest)
//                      if err != nil {
//                        t.Fatal(err)
//                      }
//                      if tt.brokenLink {
//                        // Break the symlink.
//                        os.Remove(path)
//                      }
//                      matches, err := Glob(dest)
//                      if err != nil {
//                        t.Errorf("GlobSymlink error for %q: %s", dest, err)
//                      }
//                      if !contains(matches, dest) {
//                        t.Errorf("Glob(%#q) = %#v want %v", dest, matches, dest)
//                      }
//                    }
//                  }
//
//                  type globTest struct {
//                    pattern string
//                    matches []string
//                  }
//
//                  func (test *globTest) buildWant(root string) []string {
//                    want := make([]string, 0)
//                    for _, m := range test.matches {
//                      want = append(want, root+FromSlash(m))
//                    }
//                    sort.Strings(want)
//                    return want
//                  }
//
//                  func (test *globTest) globAbs(root, rootPattern string) error {
//                    p := FromSlash(rootPattern + `\` + test.pattern)
//                    have, err := Glob(p)
//                    if err != nil {
//                      return err
//                    }
//                    sort.Strings(have)
//                    want := test.buildWant(root + `\`)
//                    if strings.Join(want, "_") == strings.Join(have, "_") {
//                      return nil
//                    }
//                    return fmt.Errorf("Glob(%q) returns %q, but %q expected", p, have, want)
//                  }
//
//                  func (test *globTest) globRel(root string) error {
//                    p := root + FromSlash(test.pattern)
//                    have, err := Glob(p)
//                    if err != nil {
//                      return err
//                    }
//                    sort.Strings(have)
//                    want := test.buildWant(root)
//                    if strings.Join(want, "_") == strings.Join(have, "_") {
//                      return nil
//                    }
//                    // try also matching version without root prefix
//                    wantWithNoRoot := test.buildWant("")
//                    if strings.Join(wantWithNoRoot, "_") == strings.Join(have, "_") {
//                      return nil
//                    }
//                    return fmt.Errorf("Glob(%q) returns %q, but %q expected", p, have, want)
//                  }
//
//                  func TestWindowsGlob(t *testing.T) {
//                    if runtime.GOOS != "windows" {
//                      t.Skipf("skipping windows specific test")
//                    }
//
//                    tmpDir, err := ioutil.TempDir("", "TestWindowsGlob")
//                    if err != nil {
//                      t.Fatal(err)
//                    }
//                    defer os.RemoveAll(tmpDir)
//
//                    // /tmp may itself be a symlink
//                    tmpDir, err = EvalSymlinks(tmpDir)
//                    if err != nil {
//                      t.Fatal("eval symlink for tmp dir:", err)
//                    }
//
//                    if len(tmpDir) < 3 {
//                      t.Fatalf("tmpDir path %q is too short", tmpDir)
//                    }
//                    if tmpDir[1] != ':' {
//                      t.Fatalf("tmpDir path %q must have drive letter in it", tmpDir)
//                    }
//
//                    dirs := []string{
//                      "a",
//                      "b",
//                      "dir/d/bin",
//                    }
//                    files := []string{
//                      "dir/d/bin/git.exe",
//                    }
//                    for _, dir := range dirs {
//                      err := os.MkdirAll(Join(tmpDir, dir), 0777)
//                      if err != nil {
//                        t.Fatal(err)
//                      }
//                    }
//                    for _, file := range files {
//                      err := ioutil.WriteFile(Join(tmpDir, file), nil, 0666)
//                      if err != nil {
//                        t.Fatal(err)
//                      }
//                    }
//
//                    tests := []globTest{
//                      {"a", []string{"a"}},
//                      {"b", []string{"b"}},
//                      {"c", []string{}},
//                      {"*", []string{"a", "b", "dir"}},
//                      {"d*", []string{"dir"}},
//                      {"*i*", []string{"dir"}},
//                      {"*r", []string{"dir"}},
//                      {"?ir", []string{"dir"}},
//                      {"?r", []string{}},
//                      {"d*/*/bin/git.exe", []string{"dir/d/bin/git.exe"}},
//                    }
//
//                    // test absolute paths
//                    for _, test := range tests {
//                      var p string
//                      err = test.globAbs(tmpDir, tmpDir)
//                      if err != nil {
//                        t.Error(err)
//                      }
//                      // test C:\*Documents and Settings\...
//                      p = tmpDir
//                      p = strings.Replace(p, `:\`, `:\*`, 1)
//                      err = test.globAbs(tmpDir, p)
//                      if err != nil {
//                        t.Error(err)
//                      }
//                      // test C:\Documents and Settings*\...
//                      p = tmpDir
//                      p = strings.Replace(p, `:\`, `:`, 1)
//                      p = strings.Replace(p, `\`, `*\`, 1)
//                      p = strings.Replace(p, `:`, `:\`, 1)
//                      err = test.globAbs(tmpDir, p)
//                      if err != nil {
//                        t.Error(err)
//                      }
//                    }
//
//                    // test relative paths
//                    wd, err := os.Getwd()
//                    if err != nil {
//                      t.Fatal(err)
//                    }
//                    err = os.Chdir(tmpDir)
//                    if err != nil {
//                      t.Fatal(err)
//                    }
//                    defer func() {
//                      err := os.Chdir(wd)
//                      if err != nil {
//                        t.Fatal(err)
//                      }
//                    }()
//                    for _, test := range tests {
//                      err := test.globRel("")
//                      if err != nil {
//                        t.Error(err)
//                      }
//                      err = test.globRel(`.\`)
//                      if err != nil {
//                        t.Error(err)
//                      }
//                      err = test.globRel(tmpDir[:2]) // C:
//                      if err != nil {
//                        t.Error(err)
//                      }
//                    }
//                  }
//
//                  func TestNonWindowsGlobEscape(t *testing.T) {
//                    if runtime.GOOS == "windows" {
//                      t.Skipf("skipping non-windows specific test")
//                    }
//                    pattern := `\match.go`
//                    want := []string{"match.go"}
//                    matches, err := Glob(pattern)
//                    if err != nil {
//                      t.Fatalf("Glob error for %q: %s", pattern, err)
//                    }
//                    if !reflect.DeepEqual(matches, want) {
//                      t.Fatalf("Glob(%#q) = %v want %v", pattern, matches, want)
//                    }
//                  }
}
