class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int max = -1;
        for(end = 0;end<nums.length;end++){
            currentSum += nums[end];
            while(currentSum>total-x && start<=end){
                currentSum-=nums[start];
                start+=1;
            }
            if(currentSum == total-x){
                max = Math.max(max,end-start+1);
            }
        }
        return max!=-1?nums.length-max:-1;
    }
}