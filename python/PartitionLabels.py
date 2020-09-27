class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
#         # can also be a interval merge problem.
        
#         rightmost = {}
#         result = []
#         for i, n in enumerate(S): rightmost[n] = i
            
#         left, right = 0, 0
        
#         for i, n in enumerate(S):
#             right = max(right, rightmost[n]) # find this region's every letter's rightmost index
                                            
            
#             if i == right:
#                 result.append(i - left + 1)
#                 left = right + 1
        
#         return result
        rightmost = {}
        result = []
        
        for i, n in enumerate(S): rightmost[n] = i
        
        intervals = [(i, rightmost[n]) for i, n in enumerate(S)]
        
        for i in range(len(intervals)):
            if not result:
                result.append(intervals[i])
            elif result[-1][1] < intervals[i][0]:
                result.append(intervals[i])
            else:
                result[-1] = ((min(result[-1][0], intervals[i][0]), max(result[-1][1], intervals[i][1])))
                
        return map(lambda x: x[1] - x[0] + 1, result)