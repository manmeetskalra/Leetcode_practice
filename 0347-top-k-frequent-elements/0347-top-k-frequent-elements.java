class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> l = new ArrayList<Integer>(map.values());

        Collections.sort(l,Collections.reverseOrder());
        int threshold = l.get(k-1);
        int[] res = new int[k];
        int i=0;
        for(Map.Entry e : map.entrySet()){
            Integer val = (Integer)e.getValue();
            if(val>=threshold){
                res[i++] = (int)e.getKey();
                if(i==res.length){
                    return res;
                }
            }
        }
        return res;
    }
}