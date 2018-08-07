import java.math.BigInteger;

public class TestLargeFactorial {
  public static void main(String[] args){
    System.out.println(factorial(25));
  }

  static BigInteger factorial(int n){
    if(n == 1){
      return new BigInteger("1");
    }else{
      return new BigInteger(n+"").multiply(factorial(n-1));
    }
  }
  

}
