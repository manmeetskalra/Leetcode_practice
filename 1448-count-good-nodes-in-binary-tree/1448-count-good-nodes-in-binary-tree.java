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
    public int goodNodes(TreeNode root) {
        int smallestValue = Integer.MIN_VALUE;
        int[] count = new int[1];
        helper(root, smallestValue, count);
        return count[0];
    }

    public void helper(TreeNode root, int smallestValue, int[] count){
        if(root==null){
            return;
        }
        if(root.val>=smallestValue){
            count[0]++;
        }
        smallestValue = Math.max(smallestValue, root.val);
        helper(root.left,smallestValue,count);
        helper(root.right,smallestValue,count);
    }
}