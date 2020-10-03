# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # step1: find the low and high
        # step2: binarysearch(low, high)
        
        
        low, high = 0, 1
        
        while reader.get(high) <= target: # you dont have to worry about out of boundary value
            high *= 2
            
        # found the high and low, now do binarysearch
        
        
        while low <= high:
            mid = (high + low) // 2    # be careful about this high + low, high is like length - 1
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
        
#         if reader.get(low) == oob:
#             return -1 # the array is empty
#         # low is now temporarily confirmed
#         while reader.get(high) == oob:
#             high //= 2
            
#         # high is now valid
#         while reader.get(high) < target:
#             low = high
#             while reader.get(high) != oob:
#                 if reader.get(high) > target:
#                     break
#                 high *= 2
#             while reader.get(high) == oob:
#                 high //= 2
                
#         array = []
        
#         while low <= high:
#             array.append(reader.get(low))
#             low += 1
            
#         return array.index(target)