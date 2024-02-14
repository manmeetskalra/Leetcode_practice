class Solution {
    public boolean validPalindrome(String s) {
        return helper(s,0,s.length()-1,1);
    }
    public boolean helper(String s, int i, int j, int ctr){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                if(ctr==0){
                    return false;
                }else{
                    return helper(s,i+1,j,0) || helper(s,i,j-1,0);
                }
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}