class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        #  for 1,2,3, you need to minimize the cost at each step.
        
        heapq.heapify(sticks)
        result = []
        
        while len(sticks) > 1:
            result.append( heapq.heappop(sticks)+ heapq.heappop(sticks))
            heapq.heappush(sticks, result[-1])
        
        return sum(result)