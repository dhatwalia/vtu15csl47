/*
8. Find Minimum Cost Spanning Tree of a given connected undirected graph using
Kruskal'salgorithm. Use Union-Find algorithms in your program.
*/

import java.util.*;

public class Prog8 {
  private List<Edge> edges;
  private int Vertices;
  public static final int MAX_VALUE = 999;
  private int visited[];
  private int tree[][];

  public Prog8(int n) {
    Vertices = n;
    edges = new LinkedList<Edge>();
    visited = new int[Vertices + 1];
    tree = new int[n + 1][n + 1];
  }

  public void Algorithm(int M[][]) {
    boolean finished = false;
    for (int i = 1; i <= Vertices; i++)
      for (int j = 1; j <= Vertices; j++)
        if (M[i][j] != MAX_VALUE && i != j) {
          Edge edge = new Edge();
          edge.source = i;
          edge.dest = j;
          edge.weight = M[i][j];
          M[j][i] = MAX_VALUE;
          edges.add(edge);
        }
    Collections.sort(edges, new EdgeComparator());
    CheckCycle c = new CheckCycle();
    for (Edge edge : edges) {
      tree[edge.source][edge.dest] = edge.weight;
      tree[edge.dest][edge.source] = edge.weight;
      if (c.checkCycle(tree, edge.source)) {
        tree[edge.source][edge.dest] = 0;
        tree[edge.dest][edge.source] = 0;
        edge.weight = -1;
        continue;
      }
      visited[edge.source] = 1;
      visited[edge.dest] = 1;
      for (int i = 0; i < visited.length; i++)
        if (visited[i] == 0) {
          finished = false;
          break;
        } else
          finished = true;

      if (finished)
        break;
    }
  }
  public void display() {
    System.out.println("The Minimum Spanning tree is ");
    for (int i = 1; i <= Vertices; i++) {
      for (int j = 1; j <= Vertices; j++)
        System.out.print(tree[i][j] + "\t");
      System.out.println();
    }
  }
  public static void main(String[] arg) {
    int M[][];
    int n;
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the number of vertices : ");
    n = s.nextInt();
    M = new int[n + 1][n + 1];
    System.out.println("Enter the Weighted Matrix");
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++) {
        M[i][j] = s.nextInt();
        if (i == j) {
          M[i][j] = 0;
          continue;
        }
        if (M[i][j] == 0)
          M[i][j] = MAX_VALUE;
      }

    Prog8 obj = new Prog8(n);
    obj.Algorithm(M);
    obj.display();
    s.close();
  }
}

class Edge {
  int source;
  int dest;
  int weight;
}

class EdgeComparator implements Comparator<Edge> {
  //@Override
  public int compare(Edge edge1, Edge edge2) {
    if (edge1.weight < edge2.weight)
      return -1;
    if (edge1.weight > edge2.weight)
      return 1;
    return 0;
  }
}

class CheckCycle {
  private Stack<Integer> stack;
  private int M[][];
  public CheckCycle() { stack = new Stack<Integer>(); }

  public boolean checkCycle(int A[][], int source) {
    boolean cycle = false;
    int num = A[source].length - 1; // Number of nodes

    M = new int[num + 1][num + 1];

    for (int i = 1; i <= num; i++)
      for (int j = 1; j <= num; j++)
        M[i][j] = A[i][j];

    int visited[] = new int[num + 1];
    int element = source;
    int i = source;
    visited[source] = 1;
    stack.push(source);
    while (!stack.isEmpty()) {
      element = stack.peek();
      i = element;

      while (i <= num) {
        if (M[element][i] >= 1 && visited[i] == 1)
          if (stack.contains(i)) {
            cycle = true;
            return cycle;
          }
        if (M[element][i] >= 1 && visited[i] == 0) {
          stack.push(i);
          visited[i] = 1;
          M[element][i] = 0; // mark as labelled;
          M[i][element] = 0;
          element = i;
          i = 1;
          continue;
        }
        i++;
      }
      stack.pop();
    }
    return cycle;
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
