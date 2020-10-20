package coderpad.prep;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;

public class Solution_1_1 {

  @Test
  public void testUnique() {
    var s = "abcdefghi";

    assertTrue(isUnique(s));
  }

  @Test
  public void testNotUnique() {
    var s = "notunique";

    assertFalse(isUnique(s));
  }

  @Test
  public void testNull() {
    assertThrows(IllegalArgumentException.class, () -> isUnique(null));
  }

  @Test
  public void testEmpty() {
    assertTrue(isUnique(""));
  }

  @Test
  public void testBlank() {
    assertFalse(isUnique("   "));
  }

  private static boolean isUnique(String s) {
    if (s == null) {
      throw new IllegalArgumentException("'s' cannot be null");
    }
    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (s.lastIndexOf(c) > i) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
