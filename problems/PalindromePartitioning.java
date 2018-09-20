package problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  /*
  *   131. Palindrome Partitioning
  *   12:03pm 0920 revisit
  *   12:11pm 2pass
  *   #enter use cache, guess the first partition, then recursion
  *   #TODO How to determine the time complexity of recursive solutions?
  */
  public List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<>();
      
      if(s == null || s.isEmpty()) return ans;
      //#exit bug 2, do not forget partition yourself as a whole.
      if(isPalindrome(s)){
          List<String> l = new ArrayList<>();
          l.add(s);
          ans.add(l);
      }
      
      for(int i = 1; i < s.length(); i++){ //#exit do not use i <= s.length.
          String ns = s.substring(0, i);
          if(isPalindrome(ns)){
              List<List<String>> tans = partition(s.substring(i)); //#exit bug1, notice the index when using substring.
              if(tans.size() > 0){
                  for(List<String> ll : tans){
                      List<String> lll = new ArrayList<>();
                      lll.addAll(ll);
                      lll.add(0, ns);
                      ans.add(lll);
                  }
              }
          }
      }
      
      return ans;
  }
  
  public boolean isPalindrome(String s){
      return s.equals(new StringBuffer(s).reverse().toString());
  }
}
