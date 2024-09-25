class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int j=0;
        stack.push(pushed[i++]);
        while(!stack.isEmpty() || i<pushed.length){
            // System.out.println(stack.peek());
            if(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
            else if(i<pushed.length){
                stack.push(pushed[i++]);
            } else{
                return false;
            }
        }
        return true;
        
    }
}

// [0,1]

/*
Solution:
- traverse the array, push and check if peek is equal to popped[top], pop

*/