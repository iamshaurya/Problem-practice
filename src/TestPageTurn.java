public class TestPageTurn {

  public static void main(String[] args) {
    System.out.println(countpage(5, 1));
    System.out.println(countpage(5, 2));
    System.out.println(countpage(5, 3));
    System.out.println(countpage(5, 4));
    System.out.println(countpage(5, 5));
  }

  public static int countpage(int pages, int n){
    int x = 0;
    int max = getMaxN(pages);
    for(int i=0; i<=max; i++){
      if((1+(2*i)) >= n){
        x = i;
        break;
      }
    }
    return Math.min(x, max-x);
  }

  public static int getMaxN(int pages){
    return (pages)/2;
  }
}
