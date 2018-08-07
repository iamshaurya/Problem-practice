import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestPathGrid {

  // starting point: 2
  // could not step on 1
  // traverse 0
  static class Node {

    public int i;
    public int j;
    public int dist;

    public Node(int i, int j, int dist) {
      this.i = i;
      this.j = j;
      this.dist = dist;
    }
  }

  public static void main(String[] args) {
    int graph[][] = new int[][]{{0, 0, 0, 0},
                                {1, 0, 0, 1},
                                {1, 0, 0, 1},
                                {1, 1, 2, 1}
    };
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        if (graph[i][j] == 2) {
          int count = getShortestPathOut(graph, new Node(i, j, 0));
          System.out.println(count);
          break;
        }
      }
    }

  }

  public static int getShortestPathOut(int[][] input, Node src) {
    //use bfs
    Node exitNode = null;
    LinkedList<Node> q = new LinkedList<Node>();
    q.push(src);
    input[src.i][src.j] = 1;
    while (!q.isEmpty()) {
      Node n = q.pop();
      int i, j;
      i = n.i;
      j = n.j-1;
      if (i < 0 || i > input.length - 1 || j < 0 || j > input[i].length - 1) {
        exitNode = n;
        break;
      } else if (input[i][j] != 1) {
        input[i][j] = 1;
        q.push(new Node(i, j, n.dist + 1));
      }

      i = n.i;
      j = n.j+1;
      if (i < 0 || i > input.length - 1 || j < 0 || j > input[i].length - 1) {
        exitNode = n;
        break;
      } else if (input[i][j] != 1) {
        input[i][j] = 1;
        q.push(new Node(i, j, n.dist + 1));
      }

      i = n.i-1;
      j = n.j;
      if (i < 0 || i > input.length - 1 || j < 0 || j > input[i].length - 1) {
        exitNode = n;
        break;
      } else if (input[i][j] != 1) {
        input[i][j] = 1;
        q.push(new Node(i, j, n.dist + 1));
      }

      i = n.i+1;
      j = n.j;
      if (i < 0 || i > input.length - 1 || j < 0 || j > input[i].length - 1) {
        exitNode = n;
        break;
      } else if (input[i][j] != 1) {
        input[i][j] = 1;
        q.push(new Node(i, j, n.dist + 1));
      }


    }
    return exitNode.dist;
  }


}
