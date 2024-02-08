class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        boolean[] calculated = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]>=nums[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                calculated[i] = true;
                result[i]  = nums[stack.peek()];
            }
            stack.push(i);
        }
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]>=nums[stack.peek()]){
                stack.pop();
            }
            if(!calculated[i]){
                if(!stack.isEmpty()){
                    result[i]  = nums[stack.peek()];
                }else{
                    result[i]  = -1;
                }
            }
            stack.push(i);
        }
        return result;
    }
}