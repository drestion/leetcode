class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        # 9:58am
        
        #BFS
        # when there is only one goal, start from the back
        
        def dfs(start, goal):
            if start == goal:
                return True
            
            tx, ty, x, y = start[0], start[1], goal[0], goal[1]
            
            if x > tx or y > ty or tx < 1 or ty < 1:
                return False
            
            return dfs((tx - ty, ty), goal) or dfs((tx, ty-tx), goal)
        
        return dfs((tx, ty), (sx, sy))
    
    # this is somthing you can use
    # x, y
    # x, x+y
    # x, x + x+y
    # x, x + x + x+y
      
            
            