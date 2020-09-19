class Solution:
#     def merge(self, intervals: List[List[int]]) -> List[List[int]]:
#         sorted_intervals = sorted(intervals, key=lambda x: x[0])
#         ind, result, length = 0, [], len(intervals)
        
#         if length < 2:
#             return intervals
        
#         while ind + 1 < length:
#             ci, ni = sorted_intervals[ind], sorted_intervals[ind+1]
            
#             if ci[1] < ni[0]:
#                 # non-overlap
#                 result += [ci]
#                 ind += 1
#             else:
#                 # found overlap
#                 while ind + 1 < length and ci[1] >= ni[0]:
#                     ci = [min(ci[0], ni[0]), max(ci[1], ni[1])]
#                     ind += 1
#                     ni = sorted_intervals[ind]
#                 result += [ci]
        
#         if sorted_intervals[-1][0] > result[-1][1]:
#             result += [sorted_intervals[-1]]
#         else:
#             result[-1][1] = max(result[-1][1], sorted_intervals[-1][1])
        
#         return result
    
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
      # official solution
      # you can tell that for loop is much safer to deal with empty input etc.
        sorted_intervals = sorted(intervals, key=lambda x: x[0])
        result = []
        
        for i in sorted_intervals:
            if result and result[-1][1] >= i[0]:
                # overlaps
                result[-1][1] = max(result[-1][1], i[1])
            else:
                result += [i]
        
        return result
        
        