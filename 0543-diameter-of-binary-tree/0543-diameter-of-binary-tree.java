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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[] {0};
        height(root, result);

        return result[0];
    }

    private int height(TreeNode root, int[] result)
    {
        if (root == null) return 0;

        int heightLeft = height(root.left, result);
        int heightRight = height(root.right, result);

        int localResult = 0;
        if (heightLeft > 0) localResult += heightLeft; 
        if (heightRight > 0) localResult += heightRight; 

        result[0] = Math.max(result[0], localResult);

        return 1 + Math.max(heightLeft, heightRight);
    }
}