class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        int sum = 1;
        for(int i=1;i<nums.length;i++){
            res[i] = sum*nums[i-1];
            sum = res[i];
            // System.out.println(res[i]);
        }
        sum =1;
        for(int i=nums.length-2;i>=0;i--){
            sum = sum*nums[i+1];
            res[i] = sum*res[i];
            // System.out.println(res[i]);
        }
        return res;
    }
}
// [1,1,2,6]