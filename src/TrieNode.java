import java.util.HashMap;
import java.util.Map;

public class TrieNode {
  private Map<Character, TrieNode> map;
  private boolean isEndOfWord;

  public TrieNode(){
    this.map = new HashMap<Character, TrieNode>();
    this.isEndOfWord = false;
  }

  public Map<Character, TrieNode> getMap() {
    return map;
  }

  public void setMap(Map<Character, TrieNode> map) {
    this.map = map;
  }

  public boolean isEndOfWord() {
    return isEndOfWord;
  }

  public void setEndOfWord(boolean endOfWord) {
    isEndOfWord = endOfWord;
  }
}
