import java.util.Stack;

public class TestQueueStack {
    public static class StackQ<T>{
      private Stack<T> s1;
      private Stack<T> s2;

      public StackQ(){
        s1 = new Stack<>();
        s2 = new Stack<>();
      }

      public void enqueue(T value) { // Push onto newest stack
        s1.push(value);
      }

      public T peek() {
        if(s2.isEmpty()){
          while(!s1.empty()){
            s2.push(s1.pop());
          }
        }
        return s2.peek();
      }

      public T dequeue() {
        if(s2.isEmpty()){
          while(!s1.empty()){
            s2.push(s1.pop());
          }
        }
        return s2.pop();
      }
    }
}
