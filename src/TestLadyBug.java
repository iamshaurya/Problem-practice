import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestLadyBug {
  public static void main(String[] args){
    System.out.println(happyLadybugs("RBRB"));
  }

  static String happyLadybugs(String b) {
    boolean happyLG = true;
    Map<Character, Integer> bugCount = new HashMap<>();
    for(char c: b.toCharArray()){
      if(bugCount.get(new Character(c)) == null){
        bugCount.put(new Character(c), 0);
      }
      bugCount.put(new Character(c), bugCount.get(new Character(c))+1);
    }
    int ucCount = bugCount.get(new Character('_')) == null ? 0 : bugCount.get(new Character('_'));
    boolean single = false;
    for(Entry<Character, Integer> e: bugCount.entrySet()){
      if(e.getKey() != '_' && e.getValue() == 1){
        single = true;
        break;
      }
    }
    if(checkHappy(b) && !single){
      return "YES";
    }else if(ucCount > 0){
      return single ? "NO": "YES";
    }else{
      return "NO";
    }
  }

  private static boolean checkHappy(String str){
    boolean happy = true;
    int count = 1;
    char prev = str.charAt(0);
    for(int i=1; i<str.length() ; i++){
      if(prev == str.charAt(i)){
        count++;
      }else if(count == 1){
        happy = false;
        break;
      }
    }
    return !str.contains("_") && happy;
  }
}
