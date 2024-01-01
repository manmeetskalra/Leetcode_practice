/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Integer, List<Integer>> neighborss = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(!map.containsKey(temp.val)){
                Node copy = new Node(temp.val);
                map.put(temp.val,copy);
                List<Node> list = temp.neighbors;
                List<Integer> l = new ArrayList<>();
                for(int i=0;i<list.size();i++){
                    q.add(list.get(i));
                    l.add(list.get(i).val);
                }
                neighborss.put(temp.val,l);
            }
        }
        for(Map.Entry entry: map.entrySet()){
            Node curr = (Node)entry.getValue();
            List<Integer> n = neighborss.get(curr.val);
            List<Node> neighbor = new ArrayList<>();
            for(int i=0;i<n.size();i++){
                neighbor.add(map.get(n.get(i)));
            }
            curr.neighbors = neighbor;
        }
        return map.get(node.val);
    }
}