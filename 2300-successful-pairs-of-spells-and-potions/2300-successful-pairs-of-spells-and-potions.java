class Solution {
    public int binarySearch(int[] potions, long success, int val){
        int left =0;
        int right =potions.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            long product = (long)potions[mid]*val;
            if(product>=success){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            res[i] = potions.length-binarySearch(potions,success,spells[i]);
        }
        return res;
    }
}