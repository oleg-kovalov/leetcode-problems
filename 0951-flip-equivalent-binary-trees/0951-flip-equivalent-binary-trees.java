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
        if (curr1 == null) return false;
        if (curr2 == null) return false;

        int left1 = curr1.left != null ? curr1.left.val : -1;
        int right1 = curr1.right != null ? curr1.right.val : -1;
        int left2 = curr2.left != null ? curr2.left.val : -1;
        int right2 = curr2.right != null ? curr2.right.val : -1;

        if (left1 == left2 && right1 == right2)
        {
            if (! dfs(curr1.left, curr2.left)) return false;
            if (! dfs(curr1.right, curr2.right)) return false;
            return true;
        } 
        if (left1 == right2 && right1 == left2)
        {
            if (! dfs(curr1.left, curr2.right)) return false;
            if (! dfs(curr1.right, curr2.left)) return false;
            return true;
        }

        return false;
    }
}