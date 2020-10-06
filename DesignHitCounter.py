class HitCounter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # 5:12pm
        # 5:20pm
        # should maintain a deque, popleft if its timestamp is outside of currenttime - 300
        # or maintain a list, record its 300 timestamp window
        # self.h = []
        self.hits = collections.defaultdict(list)

    def hit(self, timestamp: int) -> None:
        """
        Record a hit.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        # self.h.append(timestamp)
        self.hits[timestamp + 300].append(timestamp)

    def getHits(self, timestamp: int) -> int:
        """
        Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity).
        """
#         while self.h and timestamp - self.h[0] >= 300:
#             self.h.pop(0)
            
#         return len(self.h)

        # print(self.hits)
        return sum(len(self.hits[i]) for i in self.hits if timestamp < i)


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)