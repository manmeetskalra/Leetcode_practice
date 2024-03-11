class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int remaining = 0;
        int index = 0;
        for(int i=0;i<gas.length;i++){
            int rem = gas[i]-cost[i];
            if(remaining>=0){
                remaining += rem;
            }else{
                remaining = rem;
                index=i;
            }
            // System.out.println(rem);
            sum+=rem;
            // System.out.println(sum);
        }
        if(sum<0){
            return -1;
        }
        return index;
    }
}
// [5,8,2,8]
// [6,5,6,6]
// [-1,3,-4,2]