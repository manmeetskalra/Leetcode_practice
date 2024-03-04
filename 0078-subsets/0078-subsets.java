class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,list,0,new ArrayList<>());
        return list;
    }
    public void helper(int[] nums,List<List<Integer>> list, int start, List<Integer> l){
        int n = nums.length;
        list.add(new ArrayList<>(l));
        if(start>=n){
            return;
        }
        for(int i=start;i<n;i++){
            l.add(nums[i]);
            helper(nums,list,i+1,l);
            l.remove(l.size()-1);
        }
        return;
    }
}