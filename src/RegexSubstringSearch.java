public class RegexSubstringSearch {

  public static void main(String[] args) {
    String input = "baaabab";
    String pattern = "*ba*ab";
    // String pattern = "ba*****ab";
    // String pattern = "ba*ab";
    // String pattern = "a*ab";
    // String pattern = "a*****ab";
    // String pattern = "*a*****ab";
    // String pattern = "ba*ab****";
    // String pattern = "****";
    // String pattern = "*";
    // String pattern = "aa?ab";
    // String pattern = "b*b";
    // String pattern = "a*a";
    // String pattern = "baaabab";
    // String pattern = "?baaabab";
    // String pattern = "*baaaba*";
    //System.out.println(substringsearch(input, pattern));
    System.out.println(handleRegexPattern(input, pattern));
  }

  public static boolean handleRegexPattern(String input, String pattern) {
    boolean match = false;
    int x = 0;
    int y = 0;
    while (x < input.length()) {
      if((input.charAt(x) == pattern.charAt(y)) || (pattern.charAt(y) == '?')){
        ++x;
        ++y;
      }else if((pattern.charAt(y) == '*')){
        if(y == (pattern.length()-1)){
          ++y;
          break;
        }else if((pattern.charAt(y+1) == input.charAt(x))){
          ++y;
        }else{
          ++x;
        }
      }else{
        break;
      }
    }

    if(y >= pattern.length()){
      match = true;
    }
    return match;
  }

  //lets modify it
  public static int substringsearch(String input, String pattern) {
    int index = -1;
    for (int i = 0; i < input.length(); i++) {
      for (int j = 0; j < pattern.length(); j++) {
        if ((input.charAt(i + j) != pattern.charAt(j)) && (pattern.charAt(j) != '?')) {
          index = -1;
          break;
        } else {
          index = i;
        }
      }
      if (index >= 0) {
        break;
      }
    }
    return index;
  }
}
