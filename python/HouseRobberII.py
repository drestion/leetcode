class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)
        dp = [0]*length
        if not nums:
            return 0
        
        if length == 1:
            return nums[0]
        
        if length == 2:
            return max(nums[0], nums[1])
        
        # do not rob the last house
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, length-1):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])
            
        max_money = dp[-2]
        
        # rob the last house
        dp[0] = 0
        dp[1] = nums[1]
        
        for i in range(2, length-1):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])
            
        return max(nums[-1] + dp[-3], max_money)