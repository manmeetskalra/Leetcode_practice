class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row->{
            Arrays.fill(row,-1);
        });
        dp[0][0] = 1;
        startFilling(dp,obstacleGrid,m-1,n-1);
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return dp[m-1][n-1];
    }
    public void startFilling(int[][] dp, int[][] obstacleGrid, int i, int j) {
        if(i<0 || i>dp.length-1 || j<0 || j>dp[0].length-1 || dp[i][j]!=-1) return;
        
        if(i>0 && dp[i-1][j]==-1){
            startFilling(dp, obstacleGrid, i-1, j);
        }
        
        if(j>0 && dp[i][j-1]==-1){
            startFilling(dp, obstacleGrid, i, j-1);
        }
        
        if(obstacleGrid[i][j]==1){
            dp[i][j] = 0;
        } else{
            int sum = 0;
            if(i>0){
                sum = dp[i-1][j];
            }
            if(j>0){
                sum += dp[i][j-1];
            }
            dp[i][j] = sum;
        }
        return;
    }
}