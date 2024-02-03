class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length-1;
        int partition = -1;
        for(int i=n;i>0;i--){
            if(nums[i]>nums[i-1]){
                partition = i-1;
                break;
            }
        }
        // System.out.println(partition);
        if(partition==-1){
            reverse(nums,0,n);
            return;
        }
        for(int i=n;i>partition;i--){
            if(nums[i]>nums[partition]){
                swap(nums,i,partition);
                reverse(nums,partition+1,n);
                return;
            }
        }
        return;
    }
    public void swap(int[] nums, int i, int j){
        int t  = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        return;
    }
    public void reverse(int[] nums, int i, int j){
        while(i<j){
            int t  = nums[i];
            nums[i++] = nums[j];
            nums[j--] = t;
        }
    }
}
// 231332
/*
[1,2,3]
[3,2,1]
[1,1,5]
[2,3,1,3,3,2]
*/