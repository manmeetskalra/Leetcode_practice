class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])<min){
                min = Math.abs(arr[i]-arr[i-1]);
                list.clear();
                List l = new ArrayList<>();
                l.add(arr[i-1]);
                l.add(arr[i]);
                list.add(l);
            } else if(Math.abs(arr[i]-arr[i-1])==min){
                List l = new ArrayList<>();
                l.add(arr[i-1]);
                l.add(arr[i]);
                list.add(l);
            }
        }
        return list;
    }
}