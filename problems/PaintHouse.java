package problems;

public class PaintHouse {
  /*
  *     11:33am 0921 revisit
  *     11:42am draft done.
  *     11:46am 1pass
*         #enter prefix model dp[i, color] = min(dp[i-1, ncolor] + cost(i, color)); //Try ****all**** possible choicses
*
*/
  public int minCost(int[][] costs) {
      if(costs == null || costs.length < 1 || costs[0].length < 1) return 0;
      
      int xlen = costs.length;
      int[][] dp = new int[xlen][3];
      
      for(int c = 0; c < 3; c++) dp[0][c] = costs[0][c];
      
      for(int i = 1; i < xlen; i++){
          dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
          dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
          dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
      }
      
      return Math.min(Math.min(dp[xlen-1][0], dp[xlen-1][1]), dp[xlen-1][2]);
  }
}
