class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list,n,0,0,new ArrayList<>());
        return list;
    }
    public void helper(List<String> list, int n, int open, int close, List<Character> l) {
        if(open==n && open==close){
            String str = l.toString().substring(1, 3 * l.size() - 1).replaceAll(", ", "");
            list.add(str);
            return;
        }
        if(open==0 || open==close){
            l.add('(');
            helper(list,n,open+1,close,l);
            l.remove(l.size()-1);
        } else if(open==n) {
            l.add(')');
            helper(list,n,open,close+1,l);
            l.remove(l.size()-1);
        } else {
            l.add('(');
            helper(list,n,open+1,close,l);
            l.remove(l.size()-1);
            l.add(')');
            helper(list,n,open,close+1,l);
            l.remove(l.size()-1);
        }
        return;
    }
}