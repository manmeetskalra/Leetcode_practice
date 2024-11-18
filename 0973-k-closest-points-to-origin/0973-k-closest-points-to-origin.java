class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        HashMap<Integer,Double> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
            double dis = Math.pow(points[i][0],2) + Math.pow(points[i][1],2);
            map.put(i,dis);
        }

        List<Double> l = new ArrayList<>(map.values());
        Collections.sort(l);
        double val = l.get(k-1);
        int ctr=0;
        for(int i=0;i<points.length;i++){
            if(map.get(i)<=val){
                res[ctr][0] = points[i][0];
                res[ctr][1] = points[i][1];
                ctr++;
            }
        }
        return res;
    }
}
// Solution
// - calculate distance to origin
// - store it in a map with indeces
// - get list of hash values
// - sort them
// - and get first K elements