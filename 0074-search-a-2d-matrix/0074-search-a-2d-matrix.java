class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length && j>-1){
            int curr = matrix[i][j];
            if(curr==target){
                return true;
            }
            if(curr>target){
                j--;
            } else{
                i++;
            }
        }
        return false;
    }
}