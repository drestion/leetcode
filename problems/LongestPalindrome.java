package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
  /*  #409
  *   11:10am started
  *   11:51am 2pass.
  *   #enter the longest form is all evens + all odds -1 + largest odd.
  *
  *
  */
  
  
  public int longestPalindrome(String s) {
     
     
      Map<Character, Integer> cnts = new HashMap<>();
    
      
      for(char c: s.toCharArray()){
          if(cnts.containsKey(c)){
              cnts.put(c, cnts.get(c)+1);
          }
          else{
              cnts.put(c, 1);
          }
      }
      
      int ans = 0, maxodd = Integer.MIN_VALUE;
      for(char c: cnts.keySet()){
          int cnt = cnts.get(c);
          if(cnt % 2 == 0) ans += cnt;
          else{
              maxodd = Math.max(maxodd, cnt);
              ans += cnt - 1;
          }
      }
      
      //#enter whenver you use this boundary value, check if they are still there.
      if(maxodd == Integer.MIN_VALUE) return ans;
      return ans + 1;
  }
  
}
