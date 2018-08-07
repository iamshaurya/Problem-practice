import java.util.Arrays;

public class TestPickArray {
  public static void main(String[] args){
    int[] input = new int[]{4, 6, 5, 3, 3, 1};
    System.out.println(pickingNumbers(input));
  }

  static int pickingNumbers(int[] a) {
    int preLen = 0;
    int len = 0;
    Arrays.sort(a);
    for(int i=0; i<a.length ; i++){
      for(int j=i ; j<a.length ; j++){
        if(Math.abs(a[j]-a[i]) > 1){
          break;
        }
        len++;
      }
      if(len > preLen){
        preLen = len;
      }
      len = 0;
    }
    return preLen;
  }
}
