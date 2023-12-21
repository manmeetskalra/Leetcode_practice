class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i%2==0){
                res[i] = res[i/2];
            }else{
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }
}
/*
0 - 0
1 - 1
2 - 1
3 - 2
4 - 1
5 - 2
6 - 2
7 - 3
8 - 1
00, 01, 10, 11, 100, 101, 110, 111, 1000
*/