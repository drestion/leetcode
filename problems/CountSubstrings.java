package problems;

class CountSubstrings{
 /*
    *   6:07pm 0919 started
    *
    *
    *    #enter just check if dp[i][j] is a palindrom
    *    dp[i][j] = i+1 <= j - 1 && ci == cj && dp[i+1][j-1]
    *              || i+1 > j - 1 && ci == cj
    *    #enter this is the case of substring(i, j), notice the topological order is from left to right.
    */
    public int countSubstrings(String s) {
        
        if(s == null) return 0;
        if(s.isEmpty()) return 1;
        
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int j = 0 ; j < dp.length; j++){
            for(int i = 0; i <= j; i++){
                char ci = s.charAt(i), cj = s.charAt(j);
                dp[i][j] = (i+1 <= j - 1 && ci == cj && dp[i+1][j-1])
                            || (i+1 > j - 1 && ci == cj);
                if(dp[i][j] == true) ans++;
            }
        }
        
        return ans;
    }
	
}