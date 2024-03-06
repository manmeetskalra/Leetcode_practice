class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i:nums){
            hash.put(i,hash.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(hash.values());
        int[] res = new int[k];
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        int limit = pq.poll();
        int i=0;
        for(Map.Entry entry: hash.entrySet()){
            if(i==k){
                break;
            }
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if(value>=limit){
                res[i++]  = key;
            }
        }
        return res;
    }
}