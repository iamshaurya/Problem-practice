import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShortestPathGraph {

  public static class Node {

    public Integer n;
    public List<Integer> neighboursNodes;

    public Node(int n) {
      this.n = n;
      this.neighboursNodes = new ArrayList<>();
    }
  }

  public static class Graph {

    private static final int edgeWeight = 6;
    private Node[] nodes;
    private int[] distance;

    public Graph(int size) {
      nodes = new Node[size];
      distance = new int[size];
      int i = 0;
      while (i < size) {
        nodes[i] = new Node(i);
        i++;
      }
      Arrays.fill(distance, -1);
    }

    public void addEdge(int first, int second) {
      nodes[first].neighboursNodes.add(second);
      nodes[second].neighboursNodes.add(first);
    }

    public int[] shortestReach(int startId) { // 0 indexed
      distance[startId] = 0;
      LinkedList<Node> queue = new LinkedList<>();
      queue.add(nodes[startId]);
      while (!queue.isEmpty()) {
        Node curr = queue.poll();
        for (Integer ne : curr.neighboursNodes) {
          if (distance[ne] == -1) {
            distance[ne] = distance[curr.n] + edgeWeight;
            queue.add(nodes[ne]);
          }
        }
      }
      return distance;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int queries = scanner.nextInt();

    for (int t = 0; t < queries; t++) {

      // Create a graph of size n where each edge weight is 6:
      Graph graph = new Graph(scanner.nextInt());
      int m = scanner.nextInt();

      // read and set edges
      for (int i = 0; i < m; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;

        // add each edge to the graph
        graph.addEdge(u, v);
      }

      // Find shortest reach from node s
      int startId = scanner.nextInt() - 1;
      int[] distances = graph.shortestReach(startId);

      for (int i = 0; i < distances.length; i++) {
        if (i != startId) {
          System.out.print(distances[i]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    scanner.close();
  }
}