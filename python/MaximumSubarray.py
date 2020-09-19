class Solution:
#     def maxSubArray(self, nums: List[int]) -> int:
#         #burtal force O(n2)
#         #since it involves an internal, consider two-pointer
#         # wrong algorithm
#         length = len(nums)
#         if length == 0:
#             return 0
#         if length < 2:
#             return nums[0]
        
#         left, right, pl, pr = 0, length-1, 0, length-1
        
#         a_sum, nl_sum, nr_sum = sum(nums), 0, 0
#         print(a_sum)
        
#         while left != right:
#             nl_sum = a_sum - nums[left]
#             print('***')
#             print(left)
#             # print(pl)
#             # print(right)
#             print(pr)
#             if nl_sum >= a_sum:
#                 left += 1
#                 a_sum = nl_sum
#             else:
#                 nr_sum = a_sum - nums[right]
#                 if nr_sum > a_sum:
#                     right -= 1
#                     a_sum = nr_sum
#             if left == pl and right == pr:
#                 break
#             pl = left
#             pr = right
       
        
#         print(left)
#         print(right)
#         return sum(nums[left:right])
    def maxSubArray(self, nums: List[int]) -> int:
        # now copy the official Kadane's algorithm
        # dp[i] : the max subarray sum ending at nums[i]
        # the keyword is ending...
        # if it does not ask you for index, do not worry about it.
        length = len(nums)
        if length == 0:
            return None
        if length < 2:
            return nums[0]
        
        dp = [0]*length
        dp[0] = nums[0]
        max_sum = dp[0]
        
        for i in range(1, length):
            if dp[i-1] >= 0:
                dp[i] = nums[i] + dp[i-1]
            else:
                dp[i] = nums[i]
            max_sum = max(max_sum, dp[i])
        print(dp)
        return max_sum