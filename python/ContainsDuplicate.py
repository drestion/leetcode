class Solution:
#     def containsDuplicate(self, nums: List[int]) -> bool:
#         # brutal force is O(n2) as it needs to check at least two elements
#         # to speed up, needs memory, with hash
        
#         num_dict = {}
#         for n in nums:
#             if n in num_dict.keys():
#                 return True
#             else:
#                 num_dict[n] = 1
        
#         return False
    
    def containsDuplicate(self, nums: List[int]) -> bool:
        # can also sort
        nums = sorted(nums)
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                return True
        
        return False
        