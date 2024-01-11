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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        helper(root);
        // if(left<0 && right<0){
        //     return root.val;
        // }
        // if(left < 0){
        //     return root.val + right;
        // }
        // if(right <0) {
        //     return root.val + left;
        // }
        // return root.val + Math.max(left,right);
        return max;
    }
    public int helper(TreeNode root){
        if(root.left==null && root.right==null) return root.val;
        int left = root.left!=null?helper(root.left): Integer.MIN_VALUE;
        int right = root.right!=null?helper(root.right): Integer.MIN_VALUE;
        int sum = 0;
        if(left>0){
            sum+=left;
        }
        if(right>0){
            sum+=right;
        }
        int currMax = Math.max(sum+root.val,Math.max(left,right));
        max = Math.max(max,currMax);
        return Math.max(root.val,root.val+Math.max(left,right));
    }
}