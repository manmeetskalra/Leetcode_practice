class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        helper(s,0,list,new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        return list;
    }
    public void helper(String s, int index, List<List<String>> list, List<String> l, List<String> pal, List<String> notPal){
        if(index==s.length()){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=index; i<s.length();i++){
            String str = s.substring(index, i+1);
            if(notPal.contains(str)){
                continue;
            }
            if(pal.contains(str)){
                l.add(str);
                helper(s,i+1,list,l,pal,notPal);
                l.remove(l.size()-1);
            }else{
                if(checkPalindrome(str)){
                    pal.add(str);
                    l.add(str);
                    helper(s,i+1,list,l,pal,notPal);
                    l.remove(l.size()-1);
                }else{
                    notPal.add(str);
                }
            }
        }
        return;
    }
    public boolean checkPalindrome(String s){
        if(s.length()<1) return false;
        if(s.length()==1) return true;
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}