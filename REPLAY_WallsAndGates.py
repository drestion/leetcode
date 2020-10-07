class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        # 8:40PM
        
        # find the closest 0 and BFS to that location
        # use seen to avoid duplicates
        # use memo to save computation
        
        # you can start from the zero!!!!
        
        def dfs(start, steps_so_far, successful_steps, seen, memo, m, n, rooms):
            if steps_so_far == min(min_steps_so_far):
                return  # no need to continue
            
            x, y = start[0], start[1]
            if 0 <= x < m and 0 <= y < n:
                
                if rooms[x][y] == 0:
                    successful_steps.append(steps_so_far + 1) 
                    return
                if rooms[x][y] == -1:
                    return
                if start in seen:
                    return # visited
                
                seen[start] = True
                dirs=((0,1)(0,-1)(1,0)(-1,0))
                
                for dd in dirs:
                    dx, dy = dd[0], dd[1]
                    dfs((x+dx, y+dy), steps_so_far+1, successful_steps,seen,memo, m, n, rooms)
            
        m, n = len(rooms), len(rooms[0])
        
        for x in range(m):
            for y in range(n):
                