class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int curr = 0;
        for(int i=1;i<prices.length;i++){
            int diff = prices[i]-prices[i-1];
            if(curr+diff<=0){
                curr=0;
            } else{
                curr+=diff;
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}