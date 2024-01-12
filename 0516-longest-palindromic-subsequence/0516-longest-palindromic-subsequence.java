class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        StringBuilder str = new StringBuilder();
        str.append(s);
        String t = str.reverse().toString();
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    if(i>0 && j>0){
                        dp[i][j] = dp[i-1][j-1]+1;
                    } else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(i>0 && j>0){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    } else if(i>0){
                        dp[i][j] = dp[i-1][j];
                    } else if(j>0){
                        dp[i][j] = dp[i][j-1];
                    } else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        
    }
}
