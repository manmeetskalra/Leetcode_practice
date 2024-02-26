class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for(int i=1;i<nums.length;i++){
            sum += nums[i];
            if(sum<nums[i]){
                sum = nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
/*
Solution:
- start from the start
- add integer to the sum
    - if sum<nums[i]; sum = nums[i]
    - if sum>max; change max to sum

*/