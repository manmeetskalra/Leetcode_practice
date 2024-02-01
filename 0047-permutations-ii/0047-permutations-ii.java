class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums,list,new ArrayList<>(),new ArrayList<>());
        return list;
    }
    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> l, List<Integer> used){
        if(l.size()==nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used.contains(i) || (i>0 && nums[i]==nums[i-1] && !used.contains(i-1))){
                continue;
            }
            l.add(nums[i]);
            used.add(i);
            backtrack(nums,list,l,used);
            l.remove(l.size()-1);
            used.remove(used.size()-1);
        }
    }
}