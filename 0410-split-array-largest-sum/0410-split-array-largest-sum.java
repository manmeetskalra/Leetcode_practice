class Solution {
    public int splitArray(int[] nums, int k) {
       int low = 0;
       int high = 0;
       
       for(int i=0;i<nums.length;i++){
        low = Math.max(low,nums[i]);
        high = high+nums[i];
       }

       while(low<=high){
        int mid = low+(high-low)/2;
        int ctr = helper(nums,mid);
        if(ctr<=k){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
       }
       return low;
    }
    public int helper(int[] nums, int sumMax){
        int count = 1;
        int sum = 0;
        for(int x : nums){
            if(x+sum <=sumMax){
                sum += x;
            }
            else {
                count++;
                sum = x;
            }
        }
        return count;
    }
}