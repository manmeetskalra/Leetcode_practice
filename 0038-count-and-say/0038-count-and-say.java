class Solution {
    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for(int i=1;i<n;i++){
            String curr = find(sb);
            // System.out.println(curr);
            sb.delete(0,sb.length());
            sb.append(curr);
        }
        return sb.toString();
        
    }
    public String find(StringBuffer sb){
        char c = sb.charAt(0);
        int ctr=1;
        StringBuffer newSb = new StringBuffer();
        for(int i=1;i<sb.length();i++){
            if(c==sb.charAt(i)){
                ctr++;
                continue;
            }else{
                newSb.append(String.valueOf(ctr));
                newSb.append(c);
                c=sb.charAt(i);
                ctr=1;
            }
        }
        newSb.append(String.valueOf(ctr));
        newSb.append(c);
        return newSb.toString();
    }
}