class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        #10:59am
        seen = set()
        
        
        # a shape is defined by a set of coordinates as tuples
        
        def explore(r, c, r0, c0):
            if (0 <= r < len(grid) and 0 <= c < len(grid[0]) and
                    grid[r][c] and (r, c) not in seen):
                seen.add((r, c))
                shape.add((r - r0, c - c0))  # notice how shape is defiend outside of the function
                explore(r+1, c, r0, c0)
                explore(r-1, c, r0, c0)
                explore(r, c+1, r0, c0)
                explore(r, c-1, r0, c0)

        shapes = set()
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                shape = set()
                explore(r, c, r, c)
                if shape:
                    shapes.add(frozenset(shape))  # shapes is a set, so duplicates will be automatically filtered out
                                                  # also, since it is a set, so permutations will also be filtered out
                                                  # frozenset is required, otherwise you get python errors. this is to ensure it is hashable
        return len(shapes)