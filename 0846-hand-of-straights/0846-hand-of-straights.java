class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:hand){
            pq.offer(i);
        }
        List<List<Integer>> list = new ArrayList<>();
        while(!pq.isEmpty()){
            int curr = pq.poll();
            boolean filled = false;
            for(int i=0;i<list.size();i++){
                List<Integer> l = list.get(i);
                if(l.get(l.size()-1)==curr-1){
                    if(l.size()==groupSize-1){
                        list.remove(i);
                    } else{
                        list.get(i).add(curr);
                    }
                    filled = true;
                    break;
                }
            }
            if(!filled){
                List<Integer> l = new ArrayList<>();
                l.add(curr);
                if(l.size()!=groupSize){
                    list.add(l);
                }
            }
        }
        return list.size()==0;
    }
}