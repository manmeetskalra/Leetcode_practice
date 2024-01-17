class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = dp[1] = 1;
        for(int i=1;i<s.length();i++){
            int one = s.charAt(i) - '0';
            int two = Integer.parseInt(s.substring(i-1,i+1));
            
            if(one != 0){
                dp[i+1] = dp[i];
            }
            if(two>=10 && two<=26){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
/*
- InValid combinations
    - 0*
    - >26
    - <=0
    
*/