/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuffer sb = new StringBuffer();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return dehelper(q);
    }
    
    public void helper(TreeNode root){
        if(root==null){
            sb.append("null ");
        }
        else{
            sb.append(root.val);
            sb.append(" ");
            helper(root.left);
            helper(root.right);
        }
    }
    
    public TreeNode dehelper(Queue<String> q){
        String s = q.poll();
        if(s.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = dehelper(q);
        root.right = dehelper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));