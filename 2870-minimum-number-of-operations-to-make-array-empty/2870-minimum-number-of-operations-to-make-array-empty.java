class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        int ctr=0;
        for(HashMap.Entry entry: hash.entrySet()){
            int value = (int)entry.getValue();
            if(value==1){
                return -1;
            }
            ctr = ctr + value/3;
            value = value%3;
            if(value>0){
                ctr++;
            }
        }
        return ctr;
    }
}