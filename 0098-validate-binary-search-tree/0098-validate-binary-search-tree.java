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
    public boolean isValidBST(TreeNode root) {
        return validate(root, -1L + Integer.MIN_VALUE, 1L + Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long minBoundary, long maxBoundary)
    {
        if (root == null) return true;

        if (root.val <= minBoundary || root.val >= maxBoundary) return false;

        return validate(root.left, minBoundary, root.val) && validate(root.right, root.val, maxBoundary);
    }

}