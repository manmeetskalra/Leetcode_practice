class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(candidates,target,list,l,0,0);
        return list;
    }
    public void helper(int[] candidates, int target, List<List<Integer>> list, List<Integer> l, int start, int sum){
        if(sum==target){
            list.add(new ArrayList<>(l));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i!=start && candidates[i]==candidates[i-1]){
                continue;
            }
            sum+=candidates[i];
            l.add(candidates[i]);
            helper(candidates,target,list,l,i+1,sum);
            l.remove(l.size()-1);
            sum-=candidates[i];
        }
    }
}