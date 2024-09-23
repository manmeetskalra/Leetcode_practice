class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        helper(1,n,0,k,list,new ArrayList<>());
        return list;
    }
    public void helper(int start, int end, int ctr,int k,List<List<Integer>> list,List<Integer> l){
        if(ctr==k){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=start; i<=end;i++){
            l.add(i);
            helper(i+1,end,ctr+1,k,list,l);
            l.remove(l.size()-1);
        }
        return;
    }
}