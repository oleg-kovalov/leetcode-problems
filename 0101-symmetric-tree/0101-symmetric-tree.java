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
    public boolean isSymmetric(TreeNode root) {
        
        LinkedList<TreeNode[]> stack = new LinkedList<>();
        stack.push(new TreeNode[] {root, root});

        while (stack.size() > 0)
        {
            TreeNode[] nodes = stack.pop();
            if (nodes[0] == null && nodes[0] == null) continue;
            if (nodes[0] == null || nodes[1] == null) return false;

            if (nodes[0].val != nodes[1].val) return false;
            stack.push(new TreeNode[] {nodes[0].left, nodes[1].right});
            stack.push(new TreeNode[] {nodes[0].right, nodes[1].left});
        }

        return true;
    }

    // public boolean isSymmetric(TreeNode root) {
    //     return doubleDfs(root, root);
    // }

    // private boolean doubleDfs(TreeNode root1, TreeNode root2)
    // {
    //     if (root1 == null && root2 == null) return true;
    //     if (root1 == null || root2 == null) return false;

    //     return root1.val == root2.val 
    //         && doubleDfs(root1.left, root2.right) 
    //         && doubleDfs(root1.right, root2.left); 
    // }
}