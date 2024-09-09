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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int currMax, int currMin)
    {
        if (node == null) {
            return currMax - currMin;
        }

        int currentVal = node.val;
        currMax = Math.max(currMax, currentVal);
        currMin = Math.min(currMin, currentVal);

        return Math.max(
            dfs(node.left, currMax, currMin),
            dfs(node.right, currMax, currMin));

    }
}