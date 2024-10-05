class Solution {
//     public int countGoodStrings(int low, int high, int zero, int one) {
//         List<Character> l = new ArrayList<>();
//         int[] num = new int[1];
//         int[] dp = new int[];
//         helper(low,high,zero,one,num, l);
//         return num[0];
//     }
//     public void helper(int low, int high, int zero, int one, int[] num, List<Character> l) {
//         if(l.size()>high){
//             return;
//         }
        
//         if(l.size()<=high && l.size()>=low){
//             num[0]++;
//         }
//         for(int i=0;i<zero;i++){
//             l.add('0');
//         }
//         helper(low,high,zero,one,num,l);
//         l.subList(l.size()-zero,l.size()).clear();
//         for(int i=0;i<one;i++){
//             l.add('1');
//         }
//         helper(low,high,zero,one,num,l);
//         l.subList(l.size()-one,l.size()).clear();
//         return;
//     }
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        for(int i = low; i <= high; i++){
            ans = ((ans) % mod + (helperMem(i, high, low, zero, one, dp)) % mod) % mod;
        }
        return ans;
    }
    
    public int helperMem(int val, int low, int high, int zero, int one, int[] dp){
        if(val == 0) return 1;
        if(val < 0) return 0;
        if(dp[val] != -1) return dp[val];
        int first = helperMem(val - zero, low, high, zero, one, dp);
        int second = helperMem(val - one, low, high, zero, one, dp);
        return dp[val] = (first + second) % mod;
    }
}