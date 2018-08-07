import java.util.Comparator;

public class TestPrime{
  public static void main(String[] args){
    System.out.println(solve(2));
  }

  static String solve(int n) {
    // 1 is not prime
    boolean f = true;
    if( n == 1 ){
      f = false;
    }
    else if( n == 2 ){
      f = true;
    }

    // return false n is divisible by any i from 2 to n
    int i = 1;
    while( ++i <= Math.sqrt(n) ){
      if( n % i == 0 ){
        f = false;
        break;
      }
    }

    return f? "Prime": "Not prime";
  }
}
