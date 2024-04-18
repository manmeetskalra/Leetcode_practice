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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums, int i, int j){
        if(i>j){
            return null;
        }
        int mid = (i+j)/2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = helper(nums,i,mid-1);
        curr.right = helper(nums,mid+1,j);
        return curr;
    }
}