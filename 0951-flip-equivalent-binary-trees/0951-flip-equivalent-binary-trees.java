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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);        
    }

    private boolean dfs(TreeNode curr1, TreeNode curr2)
    {
        if (curr1 == null && curr2 == null) return true;
        if (curr1 == null || curr2 == null) return false;

        if (curr1.val != curr2.val) return false;

        if (dfs(curr1.left, curr2.left) && dfs(curr1.right, curr2.right)) return true;

        return dfs(curr1.left, curr2.right) && dfs(curr1.right, curr2.left);
    }
}