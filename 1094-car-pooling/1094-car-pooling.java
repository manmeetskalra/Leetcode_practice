class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] len = new int[1001];
        for(int i=0;i<trips.length;i++){
            len[trips[i][1]]+=trips[i][0];
            len[trips[i][2]]-=trips[i][0];
        }
        int onboarded = 0;
        for(int i=0;i<=1000;i++){
            onboarded+=len[i];
            System.out.println(onboarded);
            if(onboarded>capacity) return false;
        }
        return true;
    }
}