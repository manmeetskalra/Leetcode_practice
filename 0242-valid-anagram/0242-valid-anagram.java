class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(i)){
                continue;
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
            if(map.get(s.charAt(i))==0){
                map.remove(s.charAt(i));
            }
            if(map.get(t.charAt(i))==0){
                map.remove(t.charAt(i));
            }
        }
        return map.isEmpty();
    }
}