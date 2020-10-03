class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[0]) # sort by starting time
        h = [] # store the end time
        
        # we want to check the end time, if a new meeting's start time is less than the last meeting's end time
        # we need a new meeting room
        
        for i in intervals:
            if not h:
                # the first meeting, just add it
                heapq.heappush(h, i[1]) # only add the end time
            elif i[0] < h[0]: # new meeting is before the earlist previous meeting ends so you must add a new meeting
                              # it doesnt really matter if the new meeting is also before other meeting ends, because you add
                              # a new room for it
                heapq.heappush(h, i[1]) # add a new end time
            else: # new meeting is after the earliest ending time
                   # so the earliest ending time should now be updated
                # and besides, the eariest meeting ended so the new meeting can just reuse that room
                # that's why you dont have to add a new room (by adding it to the heap)
                heapq.heappop(h) # pop the smallest value in the heap
                heapq.heappush(h, i[1]) # push the new ending time and let the heap adjust it and move the smallest 
                                        # ending time to the top of the heap
        
        # now, if the q is empty, that is fine, that means we have reused and released all meeting rooms
        # if every meeting does not overlap, then we have one ending time left in the queue
        # if two meetings overlap, then we have two ends in the queue as you can imagine.
        return len(h)
            