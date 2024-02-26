class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int i=0;
        while(i<=nums.length-1 && i<=end){
            // nums[i]==0 && start=i; i++;start++;
            // nums[i]==0 && start<i swap
            // nums[i]==2 swap with end
            // else i++;
            if(nums[i]==0){
                if(start==i){
                    i++;start++;
                }else{
                    swap(nums,start,i);
                    start++;
                }
            } else if(nums[i]==2){
                swap(nums,i,end);
                end--;
            } else{
                i++;
            }
        }
        return;
    }
    // 0,0,1,1,2,2
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}