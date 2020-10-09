class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        # 16:57pm
        # 17:01pm
        
        m = max(candies)
        return map(lambda x: x >= m - extraCandies, candies)