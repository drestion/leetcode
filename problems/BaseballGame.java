package problems;

import java.util.LinkedList;

class BaseballGame {
    /*
    *    5:05pm 1007 started
    *    5:21pm draft done
    *    5:22pm 1pass
    *
    *     #enter use the linkedlist to maintain the valid points.
    *     #Time O(1)
    *     #Space O(n)
    */
    
    public int calPoints(String[] ops) {
        LinkedList<Integer> points = new LinkedList<>();
        int ans = 0, p;
        
        for(String s : ops){ 
            if(isPoint(s)){
                p = Integer.valueOf(s);
                points.offerFirst(p);
                ans += p;
            }
            else if(s.equals("+")){
                p = 0;
                for(int i = 0; i < 2 && i < points.size(); i++) p += points.get(i);
                points.offerFirst(p);
                ans += p;
            }
            else if(s.equals("C")){
                p = points.pollFirst();
                ans -= p;
            }
            else if(s.equals("D")){
                p = points.peekFirst();
                p += p;
                points.offerFirst(p);
                ans += p;
            }
        }
        
        return ans;
    }
    
    private boolean isPoint(String s){
        return !(s.equals("C") || s.equals("D") || s.equals("+"));
    }
}