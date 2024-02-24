class Solution {
    public long minimumReplacement(int[] nums) {
        int prev = nums[nums.length-1];
        long ctr=0;
        for(int j=nums.length-2;j>=0;j--){
            if(nums[j]<=prev){
                prev = nums[j];
            }else{
                int parts = (int)(Math.ceil((double)nums[j]/prev)-1);
                ctr+=parts;
                prev = Math.min(prev,nums[j]/(parts+1));
            }
        }
        return ctr;
    }
}
// Solution:
// - find peaks from last
// - divide the peak such that, the smaller one is as large as possible but not larger than the previous element