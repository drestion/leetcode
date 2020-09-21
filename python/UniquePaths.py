

class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         # start from the result
#         # TLE
#         if m == 1 or n == 1:
#             return 1
        
#         return self.uniquePaths(m, n-1) + self.uniquePaths(m-1, n)
    
    
    def uniquePaths(self, m: int, n: int) -> int:
        # start from the beginning with memory
        dp = [[0]*n]*m
        
        
        for i in range(0, m):
            dp[i][0] = 1
        for j in range(0, n):
            dp[0][j] = 1
                
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[m-1][n-1]    
    
        