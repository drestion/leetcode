package problems;

import java.util.Stack;

class MinStack {

  /*  2:41pm 1008 started after reading official answers
  *   2:46pm draft done
*       2:49pm 2pass.
*
*          #enter you only need to know the min, you dont need to know how to find it.
*
*/
  /** initialize your data structure here. */
  Stack<Node> s;
  int min;
  
  public MinStack() {
      s = new Stack<>();
      min = Integer.MAX_VALUE;
  }
  
  public void push(int x) {
      min = Math.min(x, min);
      s.push(new Node(x, min));
  }
  
  public void pop() {
      if(s.size() > 0){
          s.pop();
          if(s.size() > 0){
              min = s.peek().min;
          }
          else{
              min = Integer.MAX_VALUE;
          }
      }
  }
  
  public int top() {
      if(s.size() > 0) return s.peek().val;
      
      return -1;
  }
  
  public int getMin() {
      if(s.size() > 0) return s.peek().min;
      
      return -1;
  }
  
  private class Node{
      int min;
      int val;
      
      public Node(int v, int m){
          this.min = m;
          this.val = v;
      }
  }
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/