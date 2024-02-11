class Solution {
    public int countSubstrings(String s) {
        int ctr = 0;
        for(int i=0;i<s.length();i++){
            ctr += helper(s,i,i);
            ctr += helper(s,i,i+1);
        }
        return ctr;
    }
    public int helper(String s, int i, int j){
        if(i<0 || j>=s.length() || s.charAt(i)!=s.charAt(j)){
            return 0;
        }
        return 1+helper(s,i-1,j+1);
    }
}