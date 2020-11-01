package coderpad.prep;

import java.util.Scanner;

public class Quicksort {

  private static void shiftLeft(int[] a, int left, int right) {
    for (int i = left; i < right; i++) {
      a[i] = a[i + 1];
    }
  }

  private static void partition(int[] a, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot = a[start];
    int last = end;
    for (int i = start + 1; i <= last; ) {
      int next = a[i];
      if (next > pivot) {
        shiftLeft(a, i, end);
        a[end] = next;
        last--;
      } else {
        i++;
      }
    }
    shiftLeft(a, start, last);
    a[last] = pivot;

    partition(a, start, last - 1);
    partition(a, last + 1, end);

    printArray(a, start, end + 1);
  }

  private static void printArray(int[] a, int start, int end) {
    for (int i = start; i < end; i++) {
      if (i > start) {
        System.out.print(" ");
      }
      System.out.print(a[i]);
    }
    System.out.println();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // line one is single integer size of array of ints
    // line two is space delimited list of ints
    /*
      7
      5 8 1 3 7 9 2
     */
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    partition(arr, 0, n - 1);

    scanner.close();
  }
}
