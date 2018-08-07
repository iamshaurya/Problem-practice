import java.util.Arrays;

public class TestMultiple {

  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5};
    int[] output = getMultiple(input);
    for(int i: output){
      System.out.println(i);
    }
  }

  private static int[] getMultiple(int[] input) {
    int[] leftMul = new int[input.length];
    int[] rightMul = new int[input.length];
    int[] ans = new int[input.length];
    Arrays.fill(leftMul, 1);
    Arrays.fill(rightMul, 1);
    for(int i=1; i<input.length ; i++){
      leftMul[i] = leftMul[i-1]*input[i-1];
    }

    for(int i=input.length-2; i>=0 ; i--){
      rightMul[i] = rightMul[i+1]*input[i+1];
    }

    for(int i=0; i<input.length ; i++){
      ans[i] = leftMul[i] * rightMul[i];
    }
    return ans;
  }
}
