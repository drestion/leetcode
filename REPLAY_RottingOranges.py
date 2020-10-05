class Solution:
#     def orangesRotting(self, grid: List[List[int]]) -> int:
#         # this is a tree/graphy traversal problem
#         # can be iteratrive using a stack 
#         # or recursive\
        
#         # no no no, this is not a traversal problem
#         if not grid or not grid[0]:
#             return 0
        
#         visited, to_visit, minutes = {}, [], 0
        
#         i_len, j_len, i, j, total_in_this_minute = len(grid), len(grid[0]), 0, 0, 0
        
#         for m in range(i_len):
#             for n in range(j_len):
#                 if grid[m][n] > 1:
#                      to_visit += [(m ,n)] 
                        
#         # if not to_visit:
#         #     return 0
        
#         total_in_this_minute = len(to_visit)
#         while to_visit:
#             for k in range(total_in_this_minute):
#                 c_node = to_visit.pop(0)
#                 i, j = c_node[0], c_node[1]
#                 visited[(i, j)] = True
#                 grid[i][j] = 2
#                 if self.isRotten(i-1, j, i_len, j_len, grid, visited): 
#                     to_visit.append((i-1, j))
#                     visited[(i-1, j)] = True
#                 if self.isRotten(i+1, j, i_len, j_len, grid, visited): 
#                     to_visit.append((i+1, j))
#                     visited[(i+1, j)] = True
#                 if self.isRotten(i, j-1, i_len, j_len, grid, visited): 
#                     to_visit.append((i, j-1))
#                     visited[(i, j-1)] = True
#                 if self.isRotten(i, j+1, i_len, j_len, grid, visited): 
#                     to_visit.append((i, j+1))
#                     visited[(i, j+1)] = True
#             total_in_this_minute = len(to_visit)    
#             minutes += 1
        
#         to_visit = []
#         for m in range(i_len):
#             for n in range(j_len):
#                 if grid[m][n] < 2:
#                      to_visit += [(m ,n)] 
        
#         return minutes - 1 if len(to_visit) == 0 else -1
        
#     def isRotten(self, i, j, i_len, j_len, grid, visited):
        
#         return 0 <= i < i_len and 0 <= j < j_len and (i, j) not in visited and grid[i][j] == 1
    
    
    def orangesRotting(self, grid):
        # BFS using all seeds instead of ONE
        n,m = len(grid), len(grid[0])
        Q = collections.deque([])
        cnt = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1: cnt += 1
                if grid[i][j] == 2: Q.append((i,j))
        res = 0
        while Q:
            for _ in range(len(Q)):
                i,j = Q.popleft()
                for x, y in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
                    if 0<=x<n and 0<=y<m and grid[x][y] == 1:
                        grid[x][y] = 2
                        cnt -= 1
                        Q.append((x,y))
            res += 1
        return max(0, res-1) if cnt == 0 else -1
    
      # def orangesRotting(self, grid: List[List[int]]) -> int:
      #   row, col = len(grid), len(grid[0])
      #   rotting = {(i, j) for i in range(row) for j in range(col) if grid[i][j] == 2}
      #   fresh = {(i, j) for i in range(row) for j in range(col) if grid[i][j] == 1}
      #   timer = 0
      #   while fresh:
      #       if not rotting: return -1
      #       # this line is amazing.can also be a pattern for BFS
      #       rotting = {(i+di, j+dj) for i, j in rotting for di, dj in [(0, 1), (1, 0), (0, -1), (-1, 0)] if (i+di, j+dj) in fresh}
      #       fresh -= rotting
      #       timer += 1
      #   return timer