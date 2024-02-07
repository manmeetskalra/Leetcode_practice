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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursive(nums,0,nums.length-1);
    }
    public TreeNode recursive(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        // if(start==end){
        //     return new TreeNode(nums[start]);
        // }
        int index = end;
        //Stack<Integer> stack = new Stack<>();
        for(int i=end-1;i>=start;i--){
            if(nums[i]>nums[index]){
                index = i;
            }
            // if(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
            //     while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
            //         stack.pop();
            //     }
            // }
            // if(stack.isEmpty()){
            //     index = i;
            // }
            // stack.push(i);
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = recursive(nums,start,index-1);
        root.right = recursive(nums,index+1,end);
        return root;
    }
}