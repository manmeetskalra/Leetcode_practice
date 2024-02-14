class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                open++;
            } else if(c==')'){
                if(open==0){
                    continue;
                }else{
                    open--;
                }
            }
            sb.append(c);
        }
        while(open>0){
            sb.deleteCharAt(sb.lastIndexOf("("));
            open--;
        }
        return sb.toString();
    }
}