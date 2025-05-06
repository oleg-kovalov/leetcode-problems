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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return balanced;
    }

    private int dfs(TreeNode root)
    {
        if (!balanced) return -1;
        if (root == null) return 0;
        
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) 
        {
            balanced = false;
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}