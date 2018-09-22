package problems;

public class IslandPerimeter {
 
    /*     9:06pm 0921 revisit
    *      9:24pm draft done
    *      9:27pm 1pass
    *     #enter dfs, mark visited cell.
    *     time: O(n2)
    *     space: O(1)
    */
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        
        return -1; // Wrong Data
    }
    
    public int dfs(int[][] grid, int i, int j){
        grid[i][j] = 2;
        int edges = 4;
        int[] dirs = {0,1,0,-1,0};
        for(int d = 0; d < 4; d++){
            int ni = i + dirs[d];
            int nj = j + dirs[d+1];
            if(isValid(grid, ni, nj)){
                if(grid[ni][nj] == 1){
                    edges += dfs(grid, ni, nj);
                    edges--;
                }
                else if(grid[ni][nj] == 2){
                    edges--;
                }
            }
        }
        
        return edges;
    }
    
    public boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
