/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hash = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node curr = new Node(temp.val);
            hash.put(temp,curr);
            temp = temp.next;
        }
        for(Map.Entry entry: hash.entrySet()){
            Node master = (Node)entry.getKey();
            Node copy = (Node)entry.getValue();
            copy.next = hash.get(master.next);
            copy.random = hash.get(master.random);
        }
        return hash.get(head);
    }
}