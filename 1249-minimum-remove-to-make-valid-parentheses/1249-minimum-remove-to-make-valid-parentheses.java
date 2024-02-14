class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int open = 0, close = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!='(' && c!=')'){
                stack.push(c);
            } else{
                if(c==')'){
                    if(open == close){
                        continue;
                    }else{
                        stack.push(c);
                        close++;
                    }
                } else{
                    stack.push(c);
                    open++;
                }
            }
        }
        open = close;
        int currClose = 0;
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c=='('){
                if(open==0 || currClose==0){
                    continue;
                }else{
                    open--;
                    currClose--;
                }
            } else if(c==')'){
                currClose++;
            }
            sb.insert(0,c);
        }
        return sb.toString();
    }
}