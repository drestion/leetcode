class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        # top down
        
        # def merge(l, r):
        #     if not l or not r:
        #         return l or r
        #     if l[0] <= r[0]:
        #         return [l[0]] + merge(l[1:], r)
        #     else:
        #         return [r[0]] + merge(l, r[1:])
        
        def merge(l, r):
            if not l or not r:
                return l or r
            
            li, ri, len_l, len_r = 0, 0, len(l), len(r)
            result = []
            
            while li < len_l and ri < len_r:
                if l[li] <= r[ri]:
                    result.append(l[li])
                    li += 1
                else:
                    result.append(r[ri])
                    ri += 1
            if li > len_l-1:
                result += r[ri:]
            else:
                result += l[li:]
            
            return result
        
#         if not nums:
#             return []
        
#         length = len(nums)
#         if length == 1:
#             return nums
        
        length = len(nums)
        if length <= 1:
            return nums
        
        left = self.sortArray(nums[0:int(length/2)])
        right = self.sortArray(nums[int(length/2):])
        
        return merge(left, right)
        