class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, new ArrayList<>());
        return list;
    }
    public void helper(int[] nums, List<List<Integer>> list, List<Integer> l){
        if(l.size()==nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(l.contains(nums[i])){
                continue;
            }else{
                l.add(nums[i]);
                helper(nums,list,l);
                l.remove(l.size()-1);
            }
        }
        return;
    }
}