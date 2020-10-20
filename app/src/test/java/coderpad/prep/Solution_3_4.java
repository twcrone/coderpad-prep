package coderpad.prep;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Stack;

import static org.junit.Assert.*;

public class Solution_3_4 {

  private static class MyQueue<T> {
    private final Stack<T> stack1 = new Stack<T>();
    private final Stack<T> stack2 = new Stack<T>();

    public void add(T item) {
      stack1.push(item);
    }

    public T remove() {
      if (stack1.isEmpty()) {
        return null;
      }
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
      T item = stack2.pop();
      while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
      }
      return item;
    }

    public T peek() {
      if (stack1.isEmpty()) {
        return null;
      }
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
      T item = stack2.peek();
      while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
      }
      return item;
    }

    public boolean isEmpty() {
      return stack1.isEmpty();
    }
  }

  @Test
  public void testBase() {
    var queue = new MyQueue<String>();
    queue.add("This");

    assertEquals("This", queue.peek());
    assertEquals("This", queue.remove());
    assertTrue(queue.isEmpty());

    queue.add("is");
    queue.add("silly");

    assertEquals("is", queue.peek());
    assertEquals("is", queue.remove());
    assertFalse(queue.isEmpty());

    assertEquals("silly", queue.peek());
    assertEquals("silly", queue.remove());
    assertTrue(queue.isEmpty());
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
