class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        startFilling(dp,m-1,n-1);
        return dp[m-1][n-1];
    }
    public void startFilling(int[][] dp, int i, int j){
        if(i<1 || i>dp.length-1 || j<1 || j>dp[i].length-1 || dp[i][j]!=0) return;
        
        if(dp[i-1][j]==0){
            startFilling(dp,i-1,j);
        }
        if(dp[i][j-1]==0){
            startFilling(dp,i,j-1);
        }
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return;
    }
}