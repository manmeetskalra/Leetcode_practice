class Solution {
    public int closedIsland(int[][] grid) {
        int ctr=0;
        boolean[] closed = new boolean[1];
        closed[0]=true;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(grid, i, j, closed);
                    if(closed[0]){
                        ctr++;
                    }
                    closed[0] = true;
                }
            }
        }
        return ctr;
    }
    public void dfs(int[][] grid, int i, int j, boolean[] closed){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!=0) return;

        if(i==0 || j==0 || i==m-1 || j==n-1){
            if(grid[i][j]==0){
                closed[0]=false;
            }
            return;
        }
        grid[i][j]=-1;

        dfs(grid,i+1,j,closed);
        dfs(grid,i-1,j,closed);
        dfs(grid,i,j+1,closed);
        dfs(grid,i,j-1,closed);
    }
}