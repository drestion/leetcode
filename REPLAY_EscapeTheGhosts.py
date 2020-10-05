class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        # just remember the algorithms
        # you can escape if you are closer to the target than ghosts.
        x, y = target
        d = abs(x) + abs(y)
        return all(d < abs(x - i) + abs(y - j) for i, j in ghosts)