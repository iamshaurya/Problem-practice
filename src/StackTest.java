import java.util.Stack;

public class StackTest {
  public static void main(String[] args){
    String in = "{[()]}";
    Stack<Character> stack = new Stack<>();
    for(Character c: in.toCharArray()){
      if(stack.empty()){
        stack.push(c);
      }else{
        Character topElement = stack.peek();
        if(closingBraces(topElement, c)){
          stack.pop();
        }else{
          stack.push(c);
        }
      }
    }

    if(stack.empty()){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }
  }

  public static boolean closingBraces(Character topEle, Character in){
    boolean ans = false;
    switch (topEle){
      case '(':
        ans = in.equals(')');
        break;
      case '{':
        ans = in.equals('}');
        break;
      case '[':
        ans = in.equals(']');
        break;
        default:
          break;
    }
    return ans;
  }
}
