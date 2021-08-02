/*
9. Find Minimum Cost Spanning Tree of a given connected undirected graph using
Prim's algorithm.
*/

import java.util.*;

public class Prog9 {
  private boolean unsettled[];
  private boolean settled[];
  private int vertices;
  private int Matrix[][];
  private int key[];
  public static final int INFINITE = 999;
  private int parent[];

  public Prog9(int v) {
    vertices = v;
    unsettled = new boolean[v + 1];
    settled = new boolean[v + 1];
    Matrix = new int[v + 1][v + 1];
    key = new int[v + 1];
    parent = new int[v + 1];
  }

  public int UCount(boolean unsettled[]) // Finds unsettled count
  {
    int count = 0;
    for (int i = 0; i < unsettled.length; i++)
      if (unsettled[i])
        count++;
    return count;
  }

  public void Algorithm(int M[][]) {
    int e; // Evaluation vertex
    for (int i = 1; i <= vertices; i++)
      for (int j = 1; j <= vertices; j++)
        Matrix[i][j] = M[i][j];

    for (int i = 1; i <= vertices; i++)
      key[i] = INFINITE;

    key[1] = 0;
    unsettled[1] = true;
    parent[1] = 1;

    while (UCount(unsettled) != 0) {
      e = UMin(unsettled);
      unsettled[e] = false;
      settled[e] = true;
      Neighbours(e);
    }
  }

  private int
  UMin(boolean[] unsettled2) // Finds minimum Key Vertex from Unsettled
  {
    int min = Integer.MAX_VALUE;
    int node = 0;
    for (int i = 1; i <= vertices; i++)
      if (unsettled[i] == true && key[i] < min) {
        node = i;
        min = key[i];
      }
    return node;
  }

  public void Neighbours(int e) // Evaluates neighbour e
  {
    for (int i = 1; i <= vertices; i++)
      if (settled[i] == false)
        if (Matrix[e][i] != INFINITE) {
          if (Matrix[e][i] < key[i]) {
            key[i] = Matrix[e][i];
            parent[i] = e;
          }
          unsettled[i] = true;
        }
  }

  public void display() {
    System.out.println("SOURCE  : DESTINATION = WEIGHT");
    for (int i = 2; i <= vertices; i++)
      System.out.println(parent[i] + "\t:\t" + i + "\t=\t" +
                         Matrix[parent[i]][i]);
  }

  public static void main(String[] arg) {
    int A[][];
    int n;
    Scanner scan = new Scanner(System.in);
    try {
      System.out.print("Enter the number of vertices : ");
      n = scan.nextInt();
      A = new int[n + 1][n + 1];

      System.out.println("Enter the Weighted Matrix");
      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++) {
          A[i][j] = scan.nextInt();
          if (i == j) {
            A[i][j] = 0;
            continue;
          }
          if (A[i][j] == 0)
            A[i][j] = INFINITE;
        }
      Prog9 obj = new Prog9(n);
      obj.Algorithm(A);
      obj.display();
    } catch (InputMismatchException inputMismatch) {
      System.out.println("Wrong Input Format");
    }
    scan.close();
  }
}
/*
Sample Input:
0 3 0 0 5 6
3 0 1 0 4 0
0 1 0 6 4 0
0 0 6 0 5 8
5 4 4 5 0 2
6 0 0 8 2 0
*/
