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
        if (root == null) return root;

        if (root.val > key)
        {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key)
        {
            root.right = deleteNode(root.right, key); 
        } else {

            if (root.left == null)
            {
                return root.right; 
            } else if (root.right == null)
            {
                return root.left;
            } else {
                // node to delete has 2 children
                // we can replace it with smallest node in right subtree
                // and run recursion again to delete smallest node
                int minVal = findMinVal(root.right);
                root.val = minVal;
                
                root.right = deleteNode(root.right, minVal);
            }
        }

        return root;
    }

    private int findMinVal(TreeNode curr)
    {
        while (curr.left != null)
        {
            curr = curr.left;
        }

        return curr.val;
    }
}