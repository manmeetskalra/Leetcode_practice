class Solution {
    public int largestRectangleArea(int[] heights) {
        // Monotonic Stack solution
        int n = heights.length;
        int[] l = new int[n];
        int[] r = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                l[i] = -1;
            } else{
                l[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                r[i] = heights.length;
            } else{
                r[i] = stack.peek();
            }
            stack.push(i);
        }
        int i=0;
        int max = 0;
        while(i<n){
            int width = r[i] - l[i] - 1;
            max = Math.max(width * heights[i], max);
            i++;
        }
        return max;
    }
}