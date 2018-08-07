import java.util.Arrays;

public class BinaryCardinality {
  public static void main(String args[]){
    int[] input = {1, 4, 7, 2};
    int[] sorted = sortByCardinality(input);
    for(int i=0 ; i<sorted.length ; i++){
      System.out.println(sorted[i]);
    }
  }

  public static int[] sortByCardinality(int[] nums){
    int[] sortedNums = new int[nums.length];
    Arrays.sort(nums);
    int numList[][] = new int[nums.length][nums.length];
    for(int i=0 ; i<nums.length ; i++){
      int cardinality = getCardinality(nums[i]);
      for(int j=0; j<nums.length;j++){
        if(numList[cardinality-1][j] == 0){
          numList[cardinality-1][j] = nums[i];
          break;
        }
      }
    }

    int k = 0;
    for(int i=0; i < nums.length ; i++){
      for(int j=0 ; j< nums.length ; j++){
        if(numList[i][j] == 0){
          break;
        }
        sortedNums[k] = numList[i][j];
        k++;
      }
    }
    return sortedNums;
  }

  public static int getCardinality(int num){
    int count = 0;
    while(num > 0){
      if((num & 1) == 1){
        count++;
      }
      num = num >> 1;
    }
    return count;
  }
}
