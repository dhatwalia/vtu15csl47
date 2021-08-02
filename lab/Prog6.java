/*
6. Implement in Java, the 0/1 Knapsack problem using (a) Dynamic Programming
method (b) Greedy method.
*/

import java.util.*;

public class Prog6 {
  static int n;
  static int p[];
  static int w[];
  static int size;

  static float solution() {
    // Knapsack algorithm
    int i = 0;
    float profit = 0;
    float f = 0;
    while (size >= w[i]) {
      profit += p[i];
      size -= w[i];
      i++;
      if (i >= n)
        break;
    }
    f = size;
    f /= w[i];
    size = 0;
    profit += f * p[i];
    return profit;
  }

  static void read() {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter data!");
    for (int i = 0; i < n; i++) {
      System.out.print("Profit[" + (i + 1) + "] : ");
      p[i] = s.nextInt();
    }
    for (int i = 0; i < n; i++) {
      System.out.print("Weight[" + (i + 1) + "] : ");
      w[i] = s.nextInt();
    }
    s.close();
  }

  static void sort() {
    int temp;
    for (int j = 0; j < n - 1; j++) {
      for (int i = 0; i < n - j - 1; i++) {
        if (p[i] / w[i] < p[i + 1] / w[i + 1]) {
          temp = p[i];
          p[i] = p[i + 1];
          p[i + 1] = temp;
          temp = w[i];
          w[i] = w[i + 1];
          w[i + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.print("Enter the number of items : ");
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    System.out.print("Enter size of Knapsack : ");
    size = s.nextInt();
    p = new int[n];
    w = new int[n];
    read();
    sort();
    System.out.println("Maximum profit is " +
                       solution()); // Solves the Knapsack Problem
    s.close();
  }
}
