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
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return inorder(root);
    }

    private int inorder(TreeNode root)
    {
        if (root == null) return -1;

        int res = inorder(root.left);
        if (res >= 0 ) return res;

        count -= 1;
        if (count == 0) return root.val;

        return inorder(root.right);
    }
}