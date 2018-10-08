package problems;

/*
*    1:39pm 1007 started
*    1:49pm draft done
*    2:13pm 3pass
*
*     #enter Use LinkedList next O(1) hasNext O(1)
*
*
*/
class StringIterator {

    private Node head;
    private Node cur;
    
    public StringIterator(String compressedString) {
        head = new Node(0, '.');
        cur = head;
        
        if(!(compressedString == null || compressedString.isEmpty())){
           fillNextStr(compressedString);
        }
        
        cur = head.next;
    }
    
    private void fillNextStr(String s){
        if(s == null || s.isEmpty()) return;
        
        char c = s.charAt(0);
        int i = 1;
        
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            i++;
        }
        
        int cnt = Integer.valueOf(s.substring(1,i));
        
        cur.next = new Node(cnt, c);
        cur = cur.next;
        
        fillNextStr(s.substring(i));
    }
    
    public char next() {
        if(hasNext()){
            char ret = cur.c;
            cur.cnt--;
            if(cur.cnt == 0){
                cur = cur.next;
            }
            return ret;
        }
        else{
            return ' ';
        }
    }
    
    public boolean hasNext() {
        return cur != null;
    }
    
    private class Node {
        char c;
        int cnt;
        Node next;
        public Node(int cnt, char c){
            this.c = c;
            this.cnt = cnt;
            this.next = null;
        }
    }
}
