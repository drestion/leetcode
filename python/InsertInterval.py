class Solution:
#     def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
#         # 13:08pm
#         # 13:30pm
#         # brutal force is O(n)
#         # can use binary search to get O(ln)
        
#         # find the overlap and then grow it.
#         length = len(intervals)
#         result, ind = [], 0
        
#         # if length == 1:
#         #     return [self.merge(intervals[0], newInterval)]
#         if length == 0:
#             return [newInterval]
        
#         oi = self.findOverlap(intervals, newInterval)
#         if oi < 0:
#             # not found
#             if newInterval[0] > intervals[-1][-1]:
#                 return intervals + [newInterval]
#             else:
#                 return [newInterval] + intervals
            
#         lo, hi, m = self.grow(intervals, newInterval, oi)
     
        
#         while ind <= lo: 
#             result += [intervals[ind]]
#             ind += 1
            
#         result += [m]
#         ind = hi
            
#         while ind < length:
#             result += [intervals[ind]]
#             ind += 1
            
#         return result
            
        
#     def findOverlap(self, intervals: List[List[int]], newInterval: List[int]) -> int:
        
#         length = len(intervals)
#         lo, hi, mid = 0, length-1, int(length/2)
        
        
#         while lo <= hi:
#             mid = int((hi+lo)/2)
#             if self.overlaps(intervals[mid], newInterval):
#                 return mid
#             elif self.onLeft(newInterval, intervals[mid]) and self.onLeft(intervals[mid+1], newInterval):
#                 return mid
#             else
#                 hi = mid - 1
#             elif:
#                 lo = mid + 1
        
#         return -1 # not found
    
#     def onLeft(self,  i1: List[int],  i2: List[int]):
#         # i2 is on left of i1
#         return i2[1] < i1[0]
    
#     def overlaps(self,  i1: List[int],  i2: List[int]):
#         return not (i1[1] < i2[0] or i2[1] < i1[0])
    
#     def merge(self,  i1: List[int],  i2: List[int]):
#         return [min(i1[0], i2[0]), max(i1[1], i2[1])]
            
    
#     def grow(self, intervals: List[List[int]], newInterval: List[int], ind: int):
        
#         length = len(intervals)
#         lo, hi = ind, ind
#         result = []
#         mil,mih = newInterval,newInterval
        
#         while lo >= 0 and self.overlaps(intervals[lo], mil):
#             mil = self.merge(intervals[lo], mil)
#             lo -= 1
        
#         while hi < length and self.overlaps(intervals[hi], mih):
#             mih = self.merge(intervals[hi], mih)
#             hi += 1
        
#         return lo, hi, self.merge(mil, mih)
            
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # O(n) is ok, do not do binary search as you have to grow anyway
        left, right = [], []
        l, r = newInterval[0], newInterval[1]
        
        left = [i for i in intervals if i[1] < l]
        right = [i for i in intervals if i[0] > r]
        
        if left + right != intervals:
            l = min(l, intervals[len(left)][0])
            r = max(r, intervals[~len(right)][1]) # this is new
        return left + [[l, r]] + right     
        