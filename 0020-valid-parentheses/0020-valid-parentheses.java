class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                if(c==')' || c==']' || c=='}'){
                    return false;
                }
                stack.push(c);
            } else{
                if(c=='(' || c=='[' || c=='{'){
                    stack.push(c);
                }else{
                    char ch = stack.peek();
                    if((ch=='(' && c!=')') || (ch=='[' && c!=']') || (ch=='{' && c!='}')){
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}