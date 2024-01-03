class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));
    }
    public int helper(int[] nums, int start, int end){
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int curr = Math.max(first+nums[i],second);
            first = second;
            second = curr;
        }
        return second;
    }
}