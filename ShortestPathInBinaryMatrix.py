class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        # 8:29PM
        #
        # BFS
        
        
#         def dfs(start, steps_so_far, finished_path, seen, grid, N):
#             x, y = start[0], start[1]
            
#             if x > N -1 or y > N - 1 or x <0 or y < 0:
#                 return
            
#             if start in seen:
#                 return
            
#             if grid[x][y] == 1:
#                 # print(x, y)
#                 return
            
#             if steps_so_far >= min(finished_path):
#                 return
            
#             if x == N-1 and y == N-1:
#                 finished_path.append(steps_so_far + 1)
#                 return
            
            
#             seen[start] = True
            
#             dirs = ((1,0),(1,-1),(1,1),(0,1),(0,-1),(-1,1),(-1,0),(-1,-1))
            
#             for dd in dirs:
#                 dfs((x+dd[0], y+dd[1]), steps_so_far+1, finished_path, seen, grid, N)
                
        
#         finished = [2**32]
#         seen = {}
#         dfs((0, 0), 0, finished, seen, grid, len(grid))
#         # print(finished)
#         # print(seen)
#         return min(finished) if len(finished) > 1 else -1


            # remember this standard BFS template
        n = len(grid)
        if grid[0][0] or grid[n-1][n-1]:
            return -1
        q = [(0, 0, 1)]
        for i, j, d in q:
            if i == n-1 and j == n-1: return d
            for x, y in ((i-1,j-1),(i-1,j),(i-1,j+1),(i,j-1),(i,j+1),(i+1,j-1),(i+1,j),(i+1,j+1)):
                if 0 <= x < n and 0 <= y < n and not grid[x][y]:
                    grid[x][y] = 1
                    q.append((x, y, d+1))
        return -1