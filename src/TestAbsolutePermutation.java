import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestAbsolutePermutation {
  public static void main(String[] args){
    for(int i: absolutePermutation(10, 1)){
      System.out.println(i);
    }
  }
  static int[] absolutePermutation(int n, int k) {
    int[] nArr = new int[n];
    int[] per = new int[n];
    Arrays.fill(per, -1);
    for(int i=1; i<=n;i++ ){
      nArr[i-1] = i;
    }

//    int index = n-1;
//    while(index >= 0){
//      for(int i=n-1 ; i>=0 ; i--){
//        if(nArr[i] != -1 && Math.abs(nArr[i]-(index+1)) == k){
//          per[index] = nArr[i];
//          nArr[i] = -1;
//          break;
//        }
//      }
//      index--;
//    }
    Set<Integer> touched = new HashSet<>();
    for(int i=0; i<n ; i++){
      int a = (i+1)+k;
      int b = (i+1)-k;
      if(b > 0 && b <= n && !touched.contains(new Integer(b))){
        touched.add(new Integer(b));
        per[i] = b;
      }else if(a > 0 && a <= n && !touched.contains(new Integer(a))){
        touched.add(new Integer(a));
        per[i] = a;
      }
    }


    return checkForNoPermutation(per) ? new int[]{-1}: per;
  }

  private static boolean checkForNoPermutation(int[] in ){
    for(int i: in){
      if(i == -1){
        return true;
      }
    }
    return false;
  }
}
