class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int sum=0;
        Arrays.stream(dp).forEach(row -> {
            Arrays.fill(row,-1);
        });
        for(int i=0;i<grid.length;i++){
            sum+=grid[i][0];
            dp[i][0] = sum;
        }
        sum=0;
        for(int i=0;i<grid[0].length;i++){
            sum+=grid[0][i];
            dp[0][i] = sum;
        }
        startFilling(dp, grid, dp.length-1, dp[0].length-1);
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return dp[dp.length-1][dp[0].length-1];
    }
    public void startFilling(int[][] dp, int[][] grid, int i, int j){
        if(i<1 || i>dp.length-1 || j<1 || j>dp[i].length-1 || dp[i][j]!=-1) return;
        if(dp[i-1][j]==-1){
            startFilling(dp,grid,i-1,j);
        }
        if(dp[i][j-1]==-1){
            startFilling(dp,grid,i,j-1);
        }
        dp[i][j] =grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
        return;
    }
}