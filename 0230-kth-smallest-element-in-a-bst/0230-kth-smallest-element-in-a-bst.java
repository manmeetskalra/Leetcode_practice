/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ctr = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        ctr = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(ctr==0){
            return;
        }
        if(root.left!=null){
            helper(root.left);
        }
        if(ctr==1){
            res = root.val;
            ctr--;
        }
        else{
            ctr--;
        }
        if(root.right!=null){
            helper(root.right);
        }
        return;
    }
}