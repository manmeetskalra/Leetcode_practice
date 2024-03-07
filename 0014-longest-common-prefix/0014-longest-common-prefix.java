class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        sb.append(strs[0]);
        for(int i=1;i<strs.length;i++){
            String curr = strs[i];
            if(curr.length()==0){
                return "";
            }
            int len = Math.min(sb.length(),curr.length());
            for(int j=0;j<len;j++){
                if(curr.charAt(j)!=sb.charAt(j)){
                    sb.delete(0,sb.length());
                    sb.append(curr.substring(0,j));
                    break;
                }
            }
            if(sb.length()>len){
                sb.delete(len,sb.length());
            }
        }
        return sb.toString();
    }
}