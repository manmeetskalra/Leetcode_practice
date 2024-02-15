class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = nums.length-k+1;
        for(int i:nums){
            pq.add(i);
            if(pq.size()>max){
                pq.poll();
            }
        }
        return pq.isEmpty()?-1:pq.poll();
    }
}