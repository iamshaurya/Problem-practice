import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestMedian {

  public static void main(String[] args) {
    int[] in = {12, 4, 5, 3, 8, 7};
    List<Double> median = new ArrayList<Double>(in.length);

    calculateMedian(in, median);

    for (Double d : median) {
      System.out.println(d);
    }
  }

  public static void calculateMedian(int[] in, List<Double> median) {
    PriorityQueue<Integer> lowerHeap = new PriorityQueue<Integer>(in.length,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return -1 * o1.compareTo(o2);
          }
        });
    PriorityQueue<Integer> upperHeap = new PriorityQueue<Integer>(in.length);
    for (int i : in) {
      addToQueue(lowerHeap, upperHeap, i);
      rebalance(lowerHeap, upperHeap);
      getMedian(lowerHeap, upperHeap, median);
    }
  }

  private static void addToQueue(PriorityQueue<Integer> lowerHeap,
      PriorityQueue<Integer> upperHeap, int data) {
    if (lowerHeap.size() == 0) {
      lowerHeap.add(data);
    } else if (lowerHeap.peek() >= data) {
      lowerHeap.add(data);
    } else {
      upperHeap.add(data);
    }
  }

  private static void rebalance(PriorityQueue<Integer> lowerHeap,
      PriorityQueue<Integer> upperHeap) {
    PriorityQueue<Integer> smallerHeap =
        lowerHeap.size() > upperHeap.size() ? upperHeap : lowerHeap;
    PriorityQueue<Integer> largerHeap = lowerHeap.size() > upperHeap.size() ? lowerHeap : upperHeap;
    if ((largerHeap.size() - smallerHeap.size()) > 1) {
      smallerHeap.add(largerHeap.poll());
    }
  }

  private static void getMedian(PriorityQueue<Integer> lowerHeap,
      PriorityQueue<Integer> upperHeap, List<Double> median) {
    PriorityQueue<Integer> smallerHeap =
        lowerHeap.size() > upperHeap.size() ? upperHeap : lowerHeap;
    PriorityQueue<Integer> largerHeap = lowerHeap.size() > upperHeap.size() ? lowerHeap : upperHeap;
    if ((largerHeap.size() - smallerHeap.size()) == 0) {
      median.add((double) (largerHeap.peek() + smallerHeap.peek()) / 2);
    } else {
      median.add((double) largerHeap.peek());
    }
  }
}
