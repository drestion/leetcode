package problems;

public class EditDistance {
	
	public static void main(String[] args) {
		EditDistance t = new EditDistance();
		System.out.println(t.minDistance("horse", "ros"));
	}
	 /*
   *     3:15pm 0920 started after watching dp ii @ mit
   *     4:01pm draft done
   *     4:43pm fix done.
   *     4:55pm for some reason, this dp code failed 2 /1144 test cases.
   *     #TODO Perhaps we can reformulate the problem using the prefix ?
   */
  public int minDistance(String word1, String word2) {
      if(word1 == null) word1 = "";
      if(word2 == null) word2 = "";
      
      int len1 = word1.length(), len2 = word2.length();
      
      if(len1 == 0 && len2 != 0) return len2;
      if(len1 != 0 && len2 == 0) return len1;
      if(len1 == 0 && len2 == 0) return 0;
      
      
      int[][] dp = new int[len1][len2];
      
      if(word1.charAt(len1 - 1) == word2.charAt(len2 - 1)){
          dp[len1-1][len2-1] = 0;
      }
      else{
          dp[len1-1][len2-1] = 1;
      }
      
      for(int i = len1 - 2; i >= 0; i--) {
      	if(word1.charAt(i) == word2.charAt(len2 - 1)) {
      		dp[i][len2 - 1] = dp[i+1][len2 - 1];
      	}
      	else {
      		dp[i][len2 - 1] = dp[i+1][len2 - 1] + 1;
      	}
      }
      for(int i = len2 - 2; i>=0;i--) {
      	if(word1.charAt(len1 - 1) == word2.charAt(i)) {
      		dp[len1 - 1][i] = dp[len1 - 1][i+1];
      	}
      	else {
      		dp[len1 - 1][i] = dp[len1 - 1][i+1] + 1;
      	}
      }
      
      for(int i = len1 - 2; i >= 0; i--){
          for(int j = len2 - 2; j >= 0; j--){
              if(word1.charAt(i) == word2.charAt(j)){
                  dp[i][j] = dp[i+1][j+1];
              }
              else{
                  dp[i][j] = Math.min(dp[i][j+1],     //insertion
                             Math.min(dp[i+1][j],     //deletion
                                      dp[i+1][j+1])); //mutation   
                  dp[i][j]++;
              }
             
          }
      }
      
      return dp[0][0];
  }
}
