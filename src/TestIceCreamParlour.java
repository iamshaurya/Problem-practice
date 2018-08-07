import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIceCreamParlour {

  public static void main(String[] args) {
    int sum = 4;
    int[] input = new int[]{1,4,5,3,2};
    //naiveSolution(sum, input);
    smartSolution(sum, input);
  }

  public static void naiveSolution(int sum, int[] input){
    boolean found = false;
    for(int i = 0 ; i<input.length ; i++){
      int rem = sum - input[i];
      for(int j=i ; j<input.length ; j++){
        if(rem == input[j]){
          found = true;
          System.out.println((i+1)+" "+(j+1));
          break;
        }
      }
      if(found){
        break;
      }
    }
  }

  public static void smartSolution(int sum, int[] input){
    Map<Integer, List<Integer>> valueIndex = new HashMap<>();
    for(int i=0;i<input.length;i++){
      Integer j = new Integer(input[i]);
      if(valueIndex.get(j) == null){
        valueIndex.put(j, new ArrayList<Integer>());
      }
      valueIndex.get(j).add(i);
    }

    for(int i=0; i<input.length ; i++){
      int rem = sum - input[i];
      if(valueIndex.containsKey(new Integer(rem))){
        int seconIndex = -1;
        if(rem == input[i]){
          seconIndex = valueIndex.get(new Integer(rem)).get(1);
        }else{
          seconIndex = valueIndex.get(new Integer(rem)).get(0);
        }
        System.out.println((i+1)+" "+(seconIndex+1));
        break;
      }
    }
  }
}
