class Solution:
    def canJump(self, nums: List[int]) -> bool:
        length = len(nums)
        dp = [False] * length
        
        dp[0] = True
        
        for i in range(1, length):
            for j in reversed(range(0, i)): # depending on the data, may also be TLE.
                if dp[j] and nums[j] >= (i-j):
                    dp[i] = True
                    break
            
        return dp[-1]