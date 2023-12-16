class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sol[] =new int[2];
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int f = target-nums[i];
            if(count.containsKey(f) && count.get(f)!=i)
                return new int[] {i, (int)count.get(f)};
            
        }
        throw new IllegalArgumentException("No Solution");
        
    }
}