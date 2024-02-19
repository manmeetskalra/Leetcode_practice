class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for(int i=0;i<ch.length;i++){
            if(ch[ch.length-i-1]!=s.charAt(i)){
                String res = swap(s,i,ch[ch.length-i-1]);
                return Integer.parseInt(res);
            }
        }
        
        return num;
    }
    public String swap(String s, int index, int val){
        int j = s.lastIndexOf(val);
        char[] c = s.toCharArray();
        char curr = c[index];
        c[index] = c[j];
        c[j] = curr;
        return String.valueOf(c);
    }
}

// Solution:
// - first n is not highest
//     - swap with the highest number
// - first n is highest
//     see if second is highest
    