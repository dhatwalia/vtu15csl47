/*
5. Sort a given set of n integer elements using Merge Sort method and compute
its time complexity. Run the program for varied values of n> 5000, and record
the time taken to sort. Plot a graph of the time taken versus non graph sheet.
The elements can be read from a file or can be generated using the random number
generator. Demonstrate using Java how the divide-and-conquer method works along
with its time complexity analysis: worst case, average case and best case.
*/

import java.util.Random;
import java.util.Scanner;

public class Prog5 {
  public static void main(String args[]) {
    int i, n;
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the number of elements : ");
    n = s.nextInt();
    int a[] = new int[n];
    for (i = 0; i < n; i++) {
      Random r = new Random();
      a[i] = r.nextInt(100);
    }
    // for(i=0;i<n;i++)
    // System.out.println(a[i]);
    long st = System.nanoTime();
    sort(a, 0, n - 1);
    long et = System.nanoTime();
    double times = (double)(et - st) / 1000000;
    System.out.print("Time complexity = " + times + "s");
    // for(i=0;i<n;i++)
    // System.out.println(a[i]);
    s.close();
  }
  public static void merge(int a[], int l, int r) {
    int n1, n2;
    int m = (r + l) / 2;
    n1 = m - l + 1;
    n2 = r - m;
    int left[] = new int[n1];
    int right[] = new int[n2];
    for (int i = 0; i < n1; i++)
      left[i] = a[l + i];
    for (int i = 0; i < n2; i++)
      right[i] = a[m + 1 + i];
    int i = 0, j = 0, k = 0;
    int l1 = left.length;
    int l2 = right.length;
    while (i < l1 && j < l2) {
      if (left[i] < right[j]) {
        a[k] = left[i];
        i++;
        k++;
      } else {
        a[k] = right[j];
        j++;
        k++;
      }
    }
    if (i != l1)
      for (; i < l1; i++) // i=i
      {
        a[k] = left[i];
        k++;
      }
    else if (j != l2)
      for (; j < l2; j++) // i=i
      {
        a[k] = right[j];
        k++; // added
      }
  }

  public static void sort(int a[], int b, int e) {
    if (b < e) {
      int m = (b + e) / 2;
      sort(a, b, m);
      sort(a, m + 1, e);
      merge(a, b, e);
    }
  }
}
