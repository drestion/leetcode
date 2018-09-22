package problems;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII t = new JumpGameII();
		int[] nums = {3,2,1};
		System.out.println(t.jump(nums));
	}
	/*
	 * 1:04PM 0922 started
	 * 1:31pm draft done.
	 * 
	 * #enter dp[i][j] = min jumps from i to j. Then ans = dp[0][len-1]; 
	 *        dp[i][j] = min(dp[i][m] + 1) if m + num[m] >= j
	 *        
	 * #enter when possible, formulate problem as prefix or sufix to reduce time   
	 * #time O(n3)   
	 * #space O(n2)      
	 */
	 public int jump(int[] nums) {
     if(nums == null || nums.length < 1) return 0;
     
     int len = nums.length;
     
     int[][] dp = new int[len][len];
     
     dp[0][0] = 0; //Explicit initialization-not needed actually
     
     for(int j = 0; j < len; j++) {
    	 for(int i = 0; i < j; i++) {
    		 if(i == j) {
    			 dp[i][j] = 0;
    		 }
    		 else if( i+1 >= j) {
    			 if(nums[i] > 0) {
    				 dp[i][j] = 1;
    			 }
    			 else {
    				 dp[i][j] = Integer.MAX_VALUE;
    			 }
    		 }
    		 else {
    			 dp[i][j] = Integer.MAX_VALUE;
    		
      		 for(int m = i+1; m < j; m++) {
      			 System.out.println("i:"+i+" j:"+j+" m:"+m);
      			 if(m + nums[m] >= j) {
      				 dp[i][j] = Math.min(dp[i][j], dp[i][m] + 1);
      			 }
      		 }
      		 // It's also possible that you jump directly to the end
      		 if(i+nums[i] >= j)
      			 dp[i][j] = Math.min(dp[i][j], 1);
    		 }
    	 }
     }
     
     return dp[0][len-1];
   }
}
