class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]==i+1){
                i++;
            }
            else{
                int n = nums[i]-1;
                if(nums[n]==nums[i]){
                    return nums[i];
                }else{
                    int temp = nums[n];
                    nums[n] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }
}