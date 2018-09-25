package problems;

public class HouseRobberII {
	public static void main(String[] args) {
		HouseRobberII t = new HouseRobberII();
		int[] nums = {2,3,4,5,6,7};
		System.out.println(t.rob(nums));
	}
  /*
  *       5:50pm 0922 started
  *       6:09pm pause
  *       6:21pm resume
  *
  *        The is a template for DP problems.
	*	If the first house is not connected to the last house:
	*	
	*	dp[i][R] : max money rob the ith house or not.
	*	
	*	However, now the first house is connected to the last one, so we need to provide this information during the recursion process. So we add an addtional dimension R1:
	*	
	*	dp[i][R][R1] : max money R(rob) ith house and R1(rob) the first house, R = 0, 1, R1 = 0, 1
	*	
	*	Initialization: all are zeros except dp[0][1][1] = nums[0];
	*	Recursion: see the codes.
	*	Finalization: dp[len-1] needs special processig since it needs extra information compared to dp[i] when i < len-1;
	*	Answer: Math.max(dp[len-1][0][0], Math.max(dp[len-1][1][0],dp[len-1][0][1])); Note that dp[len-1][1][1] = 0 since this is an invalid option.
	*	
	*	Time: O(n)
	*	Space: O(nk^2), in our case, k = 2
  */
	  public int rob(int[] nums) {
	    if(nums == null || nums.length < 1) return 0;
	    if(nums.length == 1) return nums[0];
	
	    int len = nums.length, i = 1;
	    int[][][] dp = new int[len][2][2];
	
	    dp[0][1][1] = nums[0];
	
	    for(i = 1; i < len; i++){
	        dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]);
	        dp[i][1][0] = dp[i-1][0][0] + nums[i];
	        dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][1]);
	        dp[i][1][1] = dp[i-1][0][1] + nums[i];
	    }
	
	    dp[i-1][1][1] = 0;
	
	    return Math.max(dp[i-1][0][0],  Math.max(dp[i-1][1][0],dp[i-1][0][1]));
	}
}
