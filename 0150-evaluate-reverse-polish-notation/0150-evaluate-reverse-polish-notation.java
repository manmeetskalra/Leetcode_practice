class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int continous = 0;
        for(int i=0;i<tokens.length;i++){
            String c = tokens[i];
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if(c.equals("+")){
                    res = num1+num2;
                } else if(c.equals("-")){
                    res = num1-num2;
                } else if(c.equals("*")){
                    res = num1*num2;
                } else {
                    res = num1/num2;
                }
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}