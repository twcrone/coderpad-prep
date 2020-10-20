package coderpad.prep;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Solution_2_4 {

  @Test
  public void testBase() {
    var numbers = List.of(5, 1, 2, 3, 4, 5, 6);
    var partitions = partition(numbers, 4);

    assertNotNull(partitions);
    assertFalse(partitions.isEmpty());
    assertEquals(partitions.size(), 2);

    var left = partitions.get(0);
    var right = partitions.get(1);

    assertEquals(left.size(), 3);
    assertEquals(right.size(), 4);
  }

  @Test
  public void testEdge() {
    var numbers = new ArrayList<Integer>();
    var partitions = partition(numbers, 4);

    assertNotNull(partitions);
    assertFalse(partitions.isEmpty());
    assertEquals(partitions.size(), 2);

    var left = partitions.get(0);
    var right = partitions.get(1);

    assertEquals(left.size(), 0);
    assertEquals(right.size(), 0);
  }

  @Test
  public void testError() {
    assertThrows(IllegalArgumentException.class, () -> partition(null, 4));
  }

  private static List<List<Integer>> partition(List<Integer> list, int n) {
    if (list == null) {
      throw new IllegalArgumentException("List must not be null");
    }

    var left = new ArrayList<Integer>();
    var right = new ArrayList<Integer>();
    list.forEach(
        i -> {
          if (i < n) {
            left.add(i);
          } else {
            right.add(i);
          }
        });
    return List.of(left, right);
  }
}
