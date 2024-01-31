class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int steps = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(dp[i][j]!=-1){
                    continue;
                }
                else{
                    int currVal = getMaxSteps(matrix, i, j,dp);
                    dp[i][j] = currVal;
                    steps = Math.max(steps, currVal);
                }
            }
        }
        return steps;
    }
    public int getMaxSteps(int[][] matrix, int i, int j, int[][] dp){
        // if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int currMax = 0;
        if(i>0 && matrix[i-1][j]>matrix[i][j]){
            currMax = Math.max(currMax, getMaxSteps(matrix,i-1,j,dp));
        }
        if(j>0 && matrix[i][j-1]>matrix[i][j]){
            currMax = Math.max(currMax, getMaxSteps(matrix,i,j-1,dp));
        }
        if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]){
            currMax = Math.max(currMax, getMaxSteps(matrix,i+1,j,dp));
        }
        if(j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j]){
            currMax = Math.max(currMax, getMaxSteps(matrix,i,j+1,dp));
        }
        dp[i][j] = currMax+1;
        return dp[i][j];
    }
}