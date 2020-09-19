class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        # if intervals overlap return false
        sorted_intervals=sorted(intervals, key=lambda x: x[0])
        result = None
        
        for i in sorted_intervals:
            if result and result[1] > i[0]:
                return False
            else:
                result = i
        
        return True