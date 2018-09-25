package problems;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching t = new RegularExpressionMatching();
		t.isMatch("as", "a.*");
	}
  /*
  *     8:10pm 0923 started
  *      
  *     8:39pm pause
  *     9:03pm resume
  *     9:08pm draft done.
  *      #enter BFS, may be TLE
  *     #TODO you need to finish this.
  *      #enter dp[i][j] : = true if s(i:) can be matched using p(j:), then the answer is dp[0][0]
  *
  *      Initialization:  dp[s.len-1][p.len-1] = cp == '.' || cp == cs || (cp_1 == '.' || cp_1 == cs )
  *            
  *      Recursion:       dp[i][j]= dp[i+1][j+1] && (cp == '.' || cp == '*' && (cp_1 == cs || cp_1 == '.') || cp == cs)
                                    
  */
  public boolean isMatch(String s, String p) {
      if(s == null || p == null) return false;
      if(s.isEmpty() || p.isEmpty()) return false;
      
      int slen = s.length(), plen = p.length();
      
      boolean[][] dp = new boolean[slen][plen];
      char cp = p.charAt(plen-1), cs = s.charAt(slen-1), cp_1 = '_';
      
      if(plen == 1){
          return (slen == 1 && (cp == '.' || cp == cs));
      }
      //plen > 1
      cp_1 = p.charAt(plen-2);
      dp[slen-1][plen-1] = cp == '.' || cp == cs || (cp_1 == '.' || cp_1 == cs );
      
      for(int i = slen - 1; i >= 0; i--) {
      	dp[i][plen-1] = 
      }
      
      
      
      for(int i = slen - 2; i >= 0; i--){
          for(int j = plen - 2; j >= 0; j--){
              if( j - 1 >= 0){
                  cp_1 = p.charAt(j-1);
                  dp[i][j]= dp[i+1][j+1] && (cp == '.' || cp == '*' && (cp_1 == cs || cp_1 == '.') || cp == cs);
              }
              else{
                  // j == 0
                  dp[i][j]= dp[i+1][j+1] && (cp == '.' || cp == cs);
              }
          }
      }
      
      return dp[0][0];
  }
}
