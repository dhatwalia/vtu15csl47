/*
4. Sort a given set of n integer elements using Quick Sort method and compute
its time complexity. Run the program for varied values of n> 5000 and record the
time taken to sort. Plot a graph of the time taken versus non graph sheet. The
elements can be read from a file or can be generated using the random number
generator. Demonstrate using Java how the divide-and-conquer method works along
with its time complexity analysis: worst case, average case and best case.
*/

import java.util.*;

public class Prog4 {
  public static void main(String args[]) {
    int i, n;

    Scanner s = new Scanner(System.in);
    System.out.print("Enter the number of elements :  ");
    n = s.nextInt();
    int a[] = new int[n];
    for (i = 0; i < n; i++) {
      Random r = new Random();
      a[i] = r.nextInt(2000000000);
    }
    // for(i=0;i<n;i++)
    // System.out.println(a[i]);
    long st = System.nanoTime();
    quicksorting(a, 0, n - 1);
    long et = System.nanoTime();
    double times = (double)(et - st) / 1000000;
    System.out.println("Time complexity = " + times + "s");
    // for(i=0;i<n;i++)
    //	System.out.println(a[i]);
    s.close();
  }
  public static int partition(int a[], int low, int high) {
    int pivot = a[low];
    int i = low;
    int j = high;

    while (j > i) {
      while (a[i] < pivot && i <= high && j > i)
        i = i + 1;
      while (a[j] > pivot && j >= low && j >= i)
        j--;
      if (j > i) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
    int temp = pivot;
    pivot = a[j];
    a[j] = temp;
    return j;
  }

  public static void quicksorting(int a[], int low, int high) {
    if (low < high) {
      int s = partition(a, low, high);
      // System.out.println("s="+s);
      quicksorting(a, low, s - 1);
      quicksorting(a, s + 1, high);
    }
  }
}
