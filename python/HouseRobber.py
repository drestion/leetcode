class Solution:
    def rob(self, nums: List[int]) -> int:
        # start from the head
        # ans = max(dp[-2], dp[-1]) as the money is non negative
        # and two adjacent houses can not be robbed simueanously
        length = len(nums)
        dp = [0]*length
        
        if not nums:
            return 0
        
        dp[0] = nums[0]
        
        if length < 2:
            return nums[0]
        
        dp[1] = max(dp[0], nums[1])
        
        for i in range(2, length):
            dp[i] = max(dp[i-1], dp[i-2]+nums[i])
            
        return max(dp[-2], dp[-1])