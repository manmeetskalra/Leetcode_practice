class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=prices.length-1;i>=0;i--){
            int res = -1;
            while(!stack.isEmpty() && prices[i]<stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res = stack.peek();
            }
            stack.push(prices[i]);
            result[i] = res==-1?prices[i]:prices[i]-res;
        }
        return result;
    }
}