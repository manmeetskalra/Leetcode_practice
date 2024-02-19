class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer, Double> hash = new HashMap<>();
        for(int i=0;i<points.length;i++){
            double dist = distance(points[i]);
            hash.put(i,dist);
        }
        List<Double> distances=new ArrayList<>(hash.values());
        Collections.sort(distances);
        double max = distances.get(k-1);
        int[][] res = new int[k][2];
        int j = 0;
        for(HashMap.Entry entry: hash.entrySet()){
            Integer key = (Integer)entry.getKey();
            if((Double)entry.getValue()<=max){
                res[j] = points[key];
                j++;
            }
            if(j==k) break;
        }
        return res;
    }
    public double distance(int[] points){
        return Math.sqrt(Math.pow(points[0],2)+Math.pow(points[1],2));
    }
}
// Solution
// - calculate distance to origin
// - store it in a map with indeces
// - get list of hash values
// - sort them
// - and get first K elements