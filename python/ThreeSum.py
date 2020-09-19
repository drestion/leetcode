class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # copied the original solution with three pointer, very nice
        # i think i am more into the two-pointer style
        # reminds yourself when dealing with arrays. 
        
        result = []
        length = len(nums)
        nums.sort()
        ind = 0
        
        while ind < length:
            cur, lo, hi = ind, ind+1, length-1
            # start the searching process, must be iterative, so a new while loop
            # if lo == hi, then no new info the loop breaks
            while lo < hi:
                s = nums[cur] + nums[lo] + nums[hi]
                if s == 0:
                    # found one
                    result += [[nums[cur], nums[lo], nums[hi]]]
                    # the index can not just stay here, so must move them forward
                    # but there can be duplicates, so another loop here
                    while lo < hi and nums[lo] == nums[lo+1]:
                        lo += 1
                    lo += 1 
                    
                    while lo < hi and nums[hi - 1] == nums[hi]:
                        hi -= 1
                    hi -= 1
                    # if there are all duplicates then the main loop breaks here
                elif s > 0:
                    # must reduce the sum
                    hi -= 1
                elif s < 0:
                    # must increase the sum
                    lo += 1
            # now neeed to advance ind
            # do we have any duplicates?
            while ind + 1 < length and nums[ind] == nums[ind+1]:
                ind += 1
            ind += 1
        return result
    
#     def threeSum(self, nums: List[int]) -> List[List[int]]:
#         # can be transformed to a 2sum problem
#         # O(n2)
#         # to avoid the duplicates, you can sort nums first
#         # this solution still does not avoid duplicates
#         length = len(nums)
#         result = []
        
#         if length < 3:
#             return []
        
#         sorted_nums = sorted(nums)
        
#         ind2 = 0
#         while ind2 < length:
#             cur_target = -1*sorted_nums[ind2]
#             print('current target:'+str(-1*cur_target))
#             two_sum_pairs = self.twoSumUnique([x for i, x in enumerate(sorted_nums) if i!=ind2], cur_target)
            
#             for p in two_sum_pairs:
#                 print('got a pair')
#                 print(p)
#                 result += [[-1*cur_target] + p]
                
#             while ind2 < length - 1 and sorted_nums[ind2] == sorted_nums[ind2+1]:
#                     ind2 += 1
                    
#             ind2 += 1
        
#         return result
    
#     def twoSumUnique(self, nums: List[int], target) -> List[List[int]]:
#         sum_dict = {}
#         result = []
#         sorted_nums = sorted(nums)
#         length = len(nums)
        
#         ind = 0
#         while ind < length:
#             sum_dict[sorted_nums[ind]] = ind
#             while ind < length - 1 and sorted_nums[ind] == sorted_nums[ind+1]:
#                     ind += 1
#             ind += 1
#         print(sum_dict)
#         ind = 0
#         while ind < length:
#             num = sorted_nums[ind]
#             if (target - num) in sum_dict.keys():
#                 print(' found a pair')
#                 result += [[num, nums[sum_dict[target-num]]]]
#                 print(result)
#             while ind < length - 1 and sorted_nums[ind] != sorted_nums[ind+1]:
#                 ind += 1
#             ind += 1
        
#         return result
        
        
            