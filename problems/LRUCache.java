package problems;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
  /*
  *     2:53pm 1002 started after watching huahua' video
*         3:04pm it turns out we need to implement our own doubly linked list 
*         3:21pm draft done
*         4:20pm 3pass
*           #enter random access O(1) -> Hashmap
*           #enter double linked list for O(1) removal / add
*           #exit #TODO doubly linked list operation
*/
  Node head ;
  Node tail ;
  Map<Integer, Node> m ;
  int cap;
  public LRUCache(int capacity) {
     head = new Node(-1, -1);
     tail = new Node(-2, -2);
     head.next = tail;
     head.prev = null;
     tail.prev = head;
     tail.next = null;
     m = new HashMap<>();
     cap = capacity;
  }
  
  public int get(int key) {
      if(m.containsKey(key)){
          Node n = m.get(key);
          deleteNode(n);
          addToFront(n);
          return n.val;
      }
      return -1;
  }
  
  public void put(int key, int value) {
      if(m.containsKey
         (key)){
          Node n = m.get(key);
          deleteNode(n);
          n.val = value;
          m.put(key, n);
          addToFront(n);
      }
      else{
          Node n = new Node(key, value);
          if(cap > 0){
              addToFront(n);
              m.put(key, n);
              cap--;
          }
          else{
              m.remove(tail.prev.key);
              deleteNode(tail.prev);
              addToFront(n);
              m.put(key, n);

          }
      }
  }
  
  private void addToFront(Node n){
      
      //   head -> oldfirst -> oldsecond
      //   head->n->oldfirst
      n.prev = this.head;
      n.next = this.head.next;
    
      this.head.next.prev = n;
      this.head.next = n;
      
  }
  private void deleteNode(Node n){
       //   oldfirst->n -> oldnext
      if( n != null){
          n.prev.next = n.next;
          n.next.prev = n.prev;
      }
  }
  
  private class Node{
      Node prev;
      Node next;
      int val;
      int key;
      public Node(int k, int v){
          val = v;
          key = k;
      }
  }
}
