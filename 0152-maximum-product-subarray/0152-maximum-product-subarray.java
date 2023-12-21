class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            left = left*nums[i];
            right = right*nums[nums.length-1-i];
            int currMax = Math.max(left, right);
            max = Math.max(max, currMax);
            if(left==0) left = 1;
            if(right==0) right =1;
        }
        return max;
    }
}