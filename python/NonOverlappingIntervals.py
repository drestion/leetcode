class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        # this is actually a dedupliate problem
        # so just sort it first and use the two pointer
        # removes if it overlaps
        sorted_intervals = sorted(intervals, key=lambda x: x[0])
        result = []
        
        for i in sorted_intervals:
            if result and result[-1][1] > i[0]:
                # overlaps
                if result[-1][1] > i[1]:
                    # this one is sorter
                    result[-1] = i
            else:
                result += [i]
        
        return len(intervals) - len(result)
        