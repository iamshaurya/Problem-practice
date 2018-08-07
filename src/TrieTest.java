import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TrieTest {
  private static final Map<Integer, List<Character>> t9Map = t9Map();
  public static void main(String args[]) {
    List<String> data = new ArrayList<>();
    data.add("hello");
    data.add("hell");
    data.add("helicopter");
    data.add("hospital");
    data.add("well");
    data.add("dictionary");
    data.add("car");
    data.add("book");
    TrieNode root = null;
    for(String d: data){
     root = addTrieNode(d.toCharArray(), 0, root);
    }
    //T9 dictionary, 227 = car
    List<String> res = searchByPrefix("c", root);
    for (String s: res){
      System.out.println("Prefix search :: "+s);
    }
    List<String> t9Res = new ArrayList<>();
    t9WholeWordSearch(new int[]{4,3,5,5}, 0, new StringBuilder(), t9Res, root);
    for(String t: t9Res){
      System.out.println("T9 search :: "+t);
    }
  }

  public static Map<Integer, List<Character>> t9Map(){
    Map<Integer, List<Character>> t9Map = new HashMap<>();
    t9Map.put(2, Arrays.asList('a', 'b', 'c'));
    t9Map.put(3, Arrays.asList('d', 'e', 'f'));
    t9Map.put(4, Arrays.asList('g', 'h', 'i'));
    t9Map.put(5, Arrays.asList('j', 'k', 'l'));
    t9Map.put(6, Arrays.asList('m', 'n', 'o'));
    t9Map.put(7, Arrays.asList('p', 'q', 'r', 's'));
    t9Map.put(8, Arrays.asList('t', 'u', 'v'));
    t9Map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    return t9Map;
  }

  public static void t9WholeWordSearch(int[] in, int index,StringBuilder sb, List<String> res, TrieNode next){
    if(index >= in.length && next.isEndOfWord()){
      res.add(sb.toString());
    }else{
      List<Character> clist = t9Map.get(in[index]);
      for(Character c:clist){
        if(next.getMap().get(c) != null){
          sb.append(c);
          t9WholeWordSearch(in, (index+1), new StringBuilder(sb.toString()), res, next.getMap().get(c));
          //back tracing
          sb.deleteCharAt(sb.length()-1);
        }
      }
    }
  }

  public static void searchWhole(TrieNode next, StringBuilder sb, List<String> res){
    for(Entry<Character, TrieNode> e: next.getMap().entrySet()){
      StringBuilder nSb = new StringBuilder(sb.toString());
      nSb.append(e.getKey());
      search(next.getMap().get(new Character(e.getKey())), nSb, res);
    }
    if(next.isEndOfWord()){
      res.add(sb.toString());
    }
  }

  public static List<String> searchByPrefix(String pre, TrieNode root){
    List<String> res = new ArrayList<>();
    char[] arr = pre.toCharArray();
    TrieNode next = root;
    for(char c:arr){
      next = next.getMap().get(c);
      if(next == null){
        break;
      }
    }
    if(next != null){
      search(next, new StringBuilder(pre), res);
    }
    return res;
  }

  public static void search(TrieNode next, StringBuilder sb, List<String> res){
    for(Entry<Character, TrieNode> e: next.getMap().entrySet()){
      StringBuilder nSb = new StringBuilder(sb.toString());
      nSb.append(e.getKey());
      search(next.getMap().get(new Character(e.getKey())), nSb, res);
    }
    if(next.isEndOfWord()){
      res.add(sb.toString());
    }
  }

  public static TrieNode addTrieNode(char[] data,int index, TrieNode node){
    if(node == null){
      node = new TrieNode();
    }
    if(index >= data.length){
      node.setEndOfWord(true);
      return node;
    }
    Character c = data[index];
    if(node.getMap().get(data[index]) == null){
      node.getMap().put(c, new TrieNode());
    }
    addTrieNode(data, ++index, node.getMap().get(c));
    return node;
  }
}
