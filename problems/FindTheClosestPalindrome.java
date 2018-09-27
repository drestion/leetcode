package problems;

public class FindTheClosestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

  
  /*
  *    4:53pm 0925 started
  *    5:02pm draft done
  *    #TODO it turns out that the most challenging part is "not including itself"
  *    #TODO finish this
*/
  public String nearestPalindromic(String n) {
      if(n == null || n.isEmpty()) return n;
      
      int len = n.length();
      
      if(len == 1) return "0";
      
      String[][] dp = new String[len][len];
      
      for(int j = 0; j < len; j++){
          for(int i = 0; i <= j; i++){
               StringBuffer sb = new StringBuffer();
              char ci = n.charAt(i);
              if(i == j){
                  sb.append(ci);
              }
              else if( i + 1 <= j - 1){
                  sb.append(ci);
                  sb.append(dp[i+1][j-1]);
                  sb.append(ci);
              }
              else if(i + 1 == j){
                  sb.append(ci);
                  sb.append(ci);
               
              }
             
              dp[i][j] = sb.toString();
          }
      }
      
      return dp[0][len-1];
  }
  
}
