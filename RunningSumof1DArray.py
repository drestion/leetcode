class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        i = 0
        
        while i < len(nums) - 1:
            nums[i+1] += nums[i]
            i += 1
            
        return nums