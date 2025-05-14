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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else 
        {
            // if the node is leaf
            if (root.left == null &&  root.right == null) root = null;
            else if (root.right != null)
            {
                // has right child
                root.val = nextVal(root);
                root.right = deleteNode(root.right, root.val);    
            } else 
            {
                // has only left child
                root.val = prevVal(root);
                root.left = deleteNode(root.left, root.val); 
            }
        }

        return root;
        
    }

    private int prevVal(TreeNode node)
    {
        TreeNode curr = node.left;
        while (curr.right != null) curr = curr.right;

        return curr.val;
    }

    private int nextVal(TreeNode node)
    {
        TreeNode curr = node.right;
        while (curr.left != null) curr = curr.left;

        return curr.val;
    }
}