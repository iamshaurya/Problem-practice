public class TestDenseRanking {
  public static void main(String[] args){
    int[] scores = new int[]{100,100,50,40,40,20,10};
    int[] alice = new int[]{5,25,50,120};
    int[] ans = climbingLeaderboard(scores, alice);
    for (int a: ans){
      System.out.println(a+1);
    }
  }

  static int[] climbingLeaderboard(int[] scores, int[] alice) {
    int[] set = new int[scores.length];
    int j=0;
    int prev = 0;
    for(int i: scores){
      if(set[prev] != i){
        set[j] = i;
        prev = j;
        j++;
      }
    }
    int[] ans = new int[alice.length];
    int b = 0;
    for(int a: alice){
      ans[b] = getAppropriateIndex(set, a, 0, j-1);
      b++;
    }
    return ans;
  }

  static int getAppropriateIndex(int[] in, int d, int start, int end){
    if(start<=end){
      int mid = (start+end)/2;
      if(in[mid] == d){
        return mid;
      }else if(in[mid] < d){
        return getAppropriateIndex(in, d, 0, mid-1);
      }else{
        return getAppropriateIndex(in, d, mid+1, end);
      }

    }else{
      return start;
    }
  }
}
