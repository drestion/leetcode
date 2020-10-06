class Solution:
     def numDistinctIslands2(self, grid: List[List[int]]) -> int:
            
            
            # notice how they use 8 different types of normalizations to do this
            
        n=len(grid)
        m=len(grid[0]) if n else 0
        def dfs(i,j):
            if 0<=i<n and 0<=j<m and grid[i][j]==1:
                grid[i][j]=-1
                path.append([i,j])
                dfs(i,j+1)
                dfs(i+1,j)
                dfs(i,j-1)
                dfs(i-1,j)
        def normalize(path):
            res=[[] for _ in range(8)]
            for x,y in path:
                res[0].append([x,y])
                res[1].append([x,-y])
                res[2].append([-x,y])
                res[3].append([-x,-y])   
                res[4].append([y,x])
                res[5].append([y,-x])
                res[6].append([-y,x])
                res[7].append([-y,-x])                             
            for r in res:
                r.sort()
                x0,y0=r[0]
                for p in r:
                    p[0]-=x0
                    p[1]-=y0
            res.sort()
            return tuple(c for r in res[0] for c in r)
        res=set()
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    path=[]
                    dfs(i,j)
                    path=normalize(path)
                    res.add(path)
        return len(res)
        