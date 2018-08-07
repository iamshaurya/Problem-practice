public class MaxRegion {
  static int maxRegion(int[][] grid) {
    Integer max = 0;
    for(int i = 0; i<grid.length;i++){
      for(int j=0;j<grid[i].length;j++){
        if(grid[i][j] == 1){
          int count = regionTraverse(grid, i, j);
          max = Math.max(max, count);
        }
      }
    }
    return max;
  }

  static int regionTraverse(int[][] grid, int i, int j){
    if(i<0 || i>grid.length-1 || j<0 || j>grid[i].length-1){
      return 0;
    }
    int size = 0;
    if(grid[i][j] == 1){
      grid[i][j] = 0;
      ++size;
    }else{
      return 0;
    }
    for(int row = i-1; row<=i+1; row++){
      for(int column = j-1; column<=j+1; column++){
        if(row != i || column != j){
          size += regionTraverse(grid, row, column);
        }
      }
    }

    return size;
  }

  public static void main(String[] args) {
    int[][] input = new int[][]{
        new int[] {1,1,0,0},new int[] {0,1,1,0},new int[] {0,0,1,0},new int[] {1,0,0,0}
    };
    System.out.println(maxRegion(input));
  }
}
