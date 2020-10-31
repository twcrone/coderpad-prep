package coderpad.prep;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution_10_9 {

  private static final int[][] M = {
    {0, 2, 4, 8},
    {1, 3, 5, 10},
    {4, 5, 7, 12},
    {6, 7, 7, 13}
  };

  private boolean find(int n, int[][] m) {
    return check(m, 0, m[0].length - 1, n);
  }

  private boolean check(int[][] m, int r, int c, int n) {
    if (r >= m.length || c < 0) {
      System.out.println("Not found " + n);
      return false;
    }
    int current = m[r][c];
    System.out.println(current);
    if (current == n) {
      System.out.println("Found " + n);
      return true;
    } else if (current < n) {
      return check(m, r + 1, c, n);
    } else if (current > n) {
      return check(m, r, c - 1, n);
    } else {
      System.out.println("Not found " + n);
      return false;
    }
  }

  @Test
  public void test() {
    assertTrue(find(3, M));
    assertFalse(find(21, M));
    assertTrue(find(6, M));
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
