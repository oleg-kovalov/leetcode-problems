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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0)
        {
            TreeNode node = queue.poll();
            if (node.val == subRoot.val) 
            {
                if (same(node, subRoot)) return true;
            }

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return false;
    }

    private boolean same(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return same(root1.left, root2.left) && same(root1.right, root2.right);
    }


}