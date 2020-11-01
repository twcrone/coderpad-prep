package coderpad.prep;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ColorfulNumbers {

  private boolean colorful(int n) {
    Map<String, Boolean> map = map(n);
    Set<String> powerSet = getPowerSet(n);

    for (String value : powerSet) {
      if (value.length() == 1) {
        continue;
      }
      int product = productOf(value);
      String productString = Integer.toString(productOf(value));
      if (map.get(productString) != null) {
        return false;
      } else if (product != -1) {
        map.put(productString, true);
      }
    }

    return true;
  }

  private int productOf(String s) {
    var ints = new ArrayList<Integer>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      ints.add(Integer.parseInt(s.substring(i, i + 1)));
    }
    return ints.stream().reduce(1, (x, y) -> x * y);
  }

  private Map<String, Boolean> map(int n) {
    String s = Integer.toString(n);
    var map = new HashMap<String, Boolean>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      map.put(s.substring(i, i + 1), true);
    }
    return map;
  }

  private Set<String> getPowerSet(int n) {
    String s = Integer.toString(n);
    var powerSet = new HashSet<String>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      for (int j = i + 2; j < length; j++) {
        powerSet.add(s.substring(i, j));
      }
    }
    return powerSet;
  }

  @Test
  public void test() {
    assertFalse(colorful(326));
    assertTrue(colorful(3245));
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
