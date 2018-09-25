package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtMostTwoDistinctCharacters t = new LongestSubstringwithAtMostTwoDistinctCharacters();
		System.out.println(t.lengthOfLongestSubstringTwoDistinct("abaccc"));
	}

  
  
  /*    10:44am started
 *     10:54am draft done
 *     11:39am 3pass
 *     #enter dp[i] : the longest substring ending at i. ans: max(dp[i] , 0 <= i <= len-1)
 *     dp[i] = dp[i-1] + 1 if(ci == ci_1) else len(ci_1) + 1
 *     #TODO HashMap implementation, time and storage complexity etc.
 *     #TODO needs that Substring template!
 *     Time O(n2)
 *     Space O(n)
 */
 public int lengthOfLongestSubstringTwoDistinct(String s) {
     if(s == null || s.isEmpty()) return 0;
     
     int ans = Integer.MIN_VALUE, len = s.length();
     boolean found = false;
     int[] dp = new int[len];
     dp[0] = 1;
     // #TODO bug 2 for string problems, always check len = 1's case.
     if(len == 1) return dp[0];
     Map<Character, Integer> cnts = new HashMap<>();
     // #TODO bug 1 Do not forget initialization when i starts from 1
     cnts.put(s.charAt(0), 1);
     for(int i = 1; i < len; i++){
         char c = s.charAt(i), c_1 = s.charAt(i-1);
         
         for(char cc : cnts.keySet()) {
         	if(c == cc) {
         		dp[i] = dp[i-1] + 1;
         		cnts.put(c, cnts.get(c)+1);
         		found = true;
         		break;
         	}
         }
         
         if(!found) {
             //#TODO bug 3
         	char pc = c_1;
         	int j;
         	for(j = i - 1; j >= 0; j--) {
         		if(s.charAt(j) != pc) break;
         	}
         	dp[i] = i-1-j + 1;
         	cnts = new HashMap<>();
         	cnts.put(c, 1);
         	cnts.put(c_1, dp[i]-1);         
         }
         ans = Math.max(ans, dp[i]);
         found =false;
     }
     
     return ans;
 }
}
