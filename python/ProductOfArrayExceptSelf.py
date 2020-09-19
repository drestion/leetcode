class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # brutal force is O(n2)
        # speed up by additional memory
        # copied the official solution here
        # this is simply to memorize this unique idea
         
        L, R, A = [0]*len(nums), [0]*len(nums), [0]*len(nums)
        
        L[0] = 1
        for i in range(len(nums)-1):
            L[i+1] = L[i] * nums[i]
        
        R[len(nums) - 1] = 1
        for i in range(len(nums)-1):
            R[len(nums) - 1 - i - 1] = R[len(nums) - 1 - i] * nums[len(nums) - 1 - i]
            
        for i in range(len(nums)):
            A[i] = L[i] * R[i]
            
        return A