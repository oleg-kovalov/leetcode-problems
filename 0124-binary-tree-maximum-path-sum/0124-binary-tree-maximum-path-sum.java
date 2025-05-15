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
    int seen = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Math.max(seen, findSum(root));
        
        int pathWithRoot = findSum(root);
        return Math.max(seen, pathWithRoot);
    }

    private int findSum(TreeNode root)
    {
        if (root == null) return 0;

        int leftSum = Math.max(findSum(root.left), 0);
        int rightSum = Math.max(findSum(root.right), 0);

        // cache paths that are deep in the tree - don't go through root
        seen = Math.max(seen, leftSum + root.val + rightSum);

        // return above best possible path leg
        return root.val + Math.max(leftSum, rightSum);
    }
}