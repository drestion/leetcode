class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        # first, identify the high bound
        # then do binary search
        lo, hi= 0, num
        #[1,4,9,16,25,36,49]
        
        while lo <= hi:  # you cant change this to < must be <=
            mid = (hi + lo) // 2
            print(mid)
            if mid**2 == num:
                return True
            elif mid**2 < num:
                lo = mid + 1
            else:
                hi = mid - 1
        
        return False
    
#         left = 0
#         right = num
        
#         while left <= right:
#             mid = left + (right-left)//2
#             if  mid ** 2 == num:
#                 return True
#             elif mid ** 2 > num:
#                 right = mid -1
#             else:
#                 left = mid +1
#         return False
        