class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            arr[index]++;
        }
        Arrays.sort(arr);
        HashSet<Integer> hash = new HashSet<>();
        int ctr=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==0){
                continue;
            }
            if(!hash.contains(arr[i])){
                hash.add(arr[i]);
            } else{
                while(arr[i]!=0){
                    if(hash.contains(arr[i])){
                        arr[i]--;
                        ctr++;
                    } else{
                        hash.add(arr[i]);
                        break;
                    }
                }
            }
        }
        return ctr;
    }
}