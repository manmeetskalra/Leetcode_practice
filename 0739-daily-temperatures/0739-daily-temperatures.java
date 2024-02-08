class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            int ctr=0;
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek()-i;
            }else{
                result[i]  =0;
            }
            stack.push(i);
        }
        return result;
    }
}