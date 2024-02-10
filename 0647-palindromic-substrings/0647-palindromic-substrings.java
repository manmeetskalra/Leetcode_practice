class Solution {
    public int countSubstrings(String s) {
        List<String> list = new ArrayList<>();
        helper(s,0,list);
        return list.size();
    }
    public void helper(String s, int start, List<String> list){
        if(start==s.length()){
            return;
        }
        for(int i=start;i<s.length();i++){
            String str = s.substring(start,i+1);
            if(check(str)){
                //System.out.println(str);
                list.add(str);
            }
        }
        helper(s,start+1,list);
        return;
    }
    public boolean check(String s){
        StringBuilder sb = new StringBuilder(s);
        //System.out.println("sb: " + sb + "rev: " + sb.reverse());
        String rev = sb.reverse().toString();
        return s.equals(rev);
    }
}