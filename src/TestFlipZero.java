import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFlipZero {
  public static void main(String[] args){
    int[] in = {0, 0, 0, 1};
    int m = 4;
    flip(in, m);
  }

  static void flip(int[] in, int m){
    List<Integer> zeros = new ArrayList<>();
    int[] left = new int[in.length];
    int[] right = new int[in.length];
    Arrays.fill(left, 0);
    Arrays.fill(right, 0);
    for(int i = 0; i<in.length ; i++){
      if(in[i] == 0){
        zeros.add(i);
      }
      if(i>0 && in[i-1] == 1){
        left[i] = left[i-1] + 1;
      }
    }

    for(int i = in.length-1; i>-1 ; i--){
      if(i<in.length-1 && in[i+1] == 1){
        right[i] = right[i+1] + 1;
      }
    }
    int[] mList = new int[m];
    int prevSize = 0;
    int size = 0;
    for(int i=0 ; i<=zeros.size()-m ; i++){
      for(int j = 0; j<m ;j++){
        if(j==0){
          size += left[zeros.get(i+j)];
        }
        size += right[zeros.get(i+j)];
      }
      size += m;

      if(size > prevSize){
        prevSize = size;
        size = 0;
        for(int x=0; x<m ;x++){
          mList[x] = zeros.get(i+x);
        }
      }
    }

    for(int mL: mList){
      System.out.println(mL);
    }
  }
}
