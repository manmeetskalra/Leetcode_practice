class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        int i=0;
        while(i<numRows-1){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            int j = 0;
            List<Integer> prev = list.get(i);
            while(j<i){
                l.add(prev.get(j)+prev.get(j+1));
                j++;
            }
            l.add(1);
            list.add(l);
            i++;
        }
        return list;
    }
}