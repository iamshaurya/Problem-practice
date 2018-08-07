public class TestTernary {

  public static void main(String[] args) {
      Byte a = new Byte("7");
      Byte b = a != null ? null : new Byte("7");
      System.out.println(b);
  }
}
