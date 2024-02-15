class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        String str=s.replaceAll("\\s","");
        char op = '+';
        int curr =0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                curr = (curr*10) + c-'0';
            } 
            if(!Character.isDigit(c) || i==str.length()-1){
                if(op=='-'){
                    stack.push(-curr);
                } else if(op=='+'){
                    stack.push(curr);
                } else if(op=='*'){
                    int val = stack.pop()*curr;
                    stack.push(val);
                } else{
                    int val = stack.pop()/curr;
                    stack.push(val);
                }
                op=c;
                curr=0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}