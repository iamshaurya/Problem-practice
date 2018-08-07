import java.util.ArrayList;
import java.util.List;

public class TestPermutation {

  public static void main(String[] args) {
    String input = "ABCD";
    List<String> permutations = new ArrayList<>();
    generatePermutations(input, permutations, new char[input.length()], 0);
    for (String s : permutations) {
      System.out.println(s);
    }
  }

  public static void generatePermutations(String in, List<String> permutations, char[] sb, int index) {
    if (in.length() == 1) {
      sb[index] = in.charAt(in.length()-1);
      permutations.add(new StringBuilder().append(sb).toString());
      return;
    } else {
      for(int i = 0 ; i<in.length() ; i++){
        sb[index] = in.charAt(i);
        in = swap(in, 0, i);
        generatePermutations(in.substring(1, in.length()), permutations, sb, index+1);
        in = swap(in, i, 0);
      }
    }
  }

  public static String swap(String in, int i, int j) {
    char[] inArr = in.toCharArray();
    char aux = inArr[i];
    inArr[i] = inArr[j];
    inArr[j] = aux;
    return new StringBuilder().append(inArr).toString();
  }
}
