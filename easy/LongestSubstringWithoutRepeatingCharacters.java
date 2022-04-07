/*https://leetcode.com/problems/longest-substring-without-repeating-characters/*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hash.containsKey(c) && start<=hash.get(c)){
                start = hash.get(c)+1;
            }
            hash.put(c,i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
