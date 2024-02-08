class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        String str = sortString(s1);
        for(int i=0;i<=s2.length()-len;i++){
            String perm = sortString(s2.substring(i,i+len));
            //System.out.println(perm);
            if(perm.equals(str)){
                return true;
            }
        }
        return false;
    }
    public String sortString(String str){
        char[] chars = str.toCharArray(); 
        Arrays.sort(chars); 
        String sortedString = String.valueOf(chars);
        return sortedString;
    }
}