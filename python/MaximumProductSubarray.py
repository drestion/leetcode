class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        # similar to the max subarray sum
        # kadane's algorithm
        # note it only asks for product, not indexes
        # dp[i]: maximum product of subarray ending at i
        
        
        # there are two ways to get the largest sum: min*cur or max*cur
        # carefully analyze the distribution of your data, and use those information
        length = len(nums)
        if length <= 0:
            return None
        if length < 2:
            return nums[0]
        
        dp, dp2 = [0]*length, [0]*length
        dp[0], dp2[0] = nums[0], nums[0]
        max_product = dp[0]
        
        for i in range(1, length):
            left, left2 = dp[i-1], dp2[i-1]
            
            dp2[i] = min(min(left2*nums[i], nums[i]), left*nums[i])
            dp[i] = max(max(left2*nums[i], nums[i]), left*nums[i])
            
            max_product = max(max_product, dp[i])
            
        print(dp)
        return max_product
        