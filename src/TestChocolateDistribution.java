import java.util.Arrays;

public class TestChocolateDistribution {

  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5};
    int[] dist = getDistribution(input);
    for(int i: dist){
      System.out.println(i);
    }
  }

  private static int[] getDistribution(int[] input) {
    int[] dist = new int[input.length];
    Arrays.fill(dist, 1);
    for(int i=1; i<input.length ; i++){
      if(input[i] > input[i-1]){
        dist[i] = dist[i-1] + 1;
      }
    }

    for(int i=input.length-2; i>=0 ; i--){
      if(input[i] > input[i+1] && dist[i] <= dist[i+1]){
        dist[i] = dist[i+1] + 1;
      }
    }
    return dist;
  }
}
