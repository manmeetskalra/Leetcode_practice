class Solution {

    int[] arr;
    int max;
    public Solution(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];
        for(int i=1;i<w.length;i++){
            arr[i] = arr[i-1]+w[i];
        }
        max = arr[w.length-1];
    }
    
    public int pickIndex() {
        Random random = new Random();
        int rand = random.nextInt(max);
        return getIndex(rand);
    }
    public int getIndex(int rand){
        int low = 0;
        int high = arr.length-1;
        int res = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>rand){
                res = mid;
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */