/*
7. From a given vertex in a weighted connected graph, find shortest paths to
other vertices using Dijkstra's algorithm. Write the program in Java.
*/

import java.util.*;

public class Prog7 {
  private int distances[];
  private Set<Integer> settled;
  private Set<Integer> unsettled;
  private int number_of_nodes;
  private int Matrix[][]; // Adjacency Matrix

  public Prog7(int n) // number of nodes
  {
    number_of_nodes = n;
    distances = new int[n + 1];
    settled = new HashSet<Integer>();
    unsettled = new HashSet<Integer>();
    Matrix = new int[n + 1][n + 1];
  }

  public void solution(int a[][], int source) // Dijkstra's algorithm function
  {
    int e; // Evalutation node
    for (int i = 1; i <= number_of_nodes; i++)
      for (int j = 1; j <= number_of_nodes; j++)
        Matrix[i][j] = a[i][j];

    for (int i = 1; i <= number_of_nodes; i++)
      distances[i] = Integer.MAX_VALUE;

    unsettled.add(source);
    distances[source] = 0;
    while (!unsettled.isEmpty()) {
      e = getNode();
      unsettled.remove(e);
      settled.add(e);
      Neighbours(e); // Evaluates neighbours
    }
  }

  private int getNode() // Gets Node with minimum distance from unsettled
  {
    int min;
    int node = 0;
    Iterator<Integer> iterator = unsettled.iterator();
    node = iterator.next();
    min = distances[node];
    for (int i = 1; i <= distances.length; i++) {
      if (unsettled.contains(i)) {
        if (distances[i] <= min) {
          min = distances[i];
          node = i;
        }
      }
    }
    return node;
  }

  private void Neighbours(int e) // Evaluate neighbours of e node
  {
    int ED = -1; // Edge Distance
    int ND = -1; // New Distance

    for (int i = 1; i <= number_of_nodes; i++) {
      if (!settled.contains(i)) {
        if (Matrix[e][i] != Integer.MAX_VALUE) {
          ED = Matrix[e][i];
          ND = distances[e] + ED;
          if (ND < distances[i])
            distances[i] = ND;
          unsettled.add(i);
        }
      }
    }
  }

  public static void main(String... arg) {
    int a[][];
    int n; // number_of_vertices
    int source = 0, destination = 0;
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the number of vertices : ");
    n = s.nextInt();
    a = new int[n + 1][n + 1];

    System.out.println("Enter the Weighted Matrix for the graph");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        a[i][j] = s.nextInt();
        if (i == j) {
          a[i][j] = 0;
          continue;
        }
        if (a[i][j] == 0)
          a[i][j] = Integer.MAX_VALUE;
      }
    }
    System.out.print("Enter the source : ");
    source = s.nextInt();
    System.out.print("Enter the destn. : ");
    destination = s.nextInt();

    Prog7 obj = new Prog7(n);
    obj.solution(a, source);

    System.out.print("The Shortest Path length from " + source);
    System.out.print(" to " + destination + " is ");
    for (int i = 1; i <= obj.distances.length - 1; i++)
      if (i == destination)
        System.out.println(obj.distances[i]);
    s.close();
  }
}
