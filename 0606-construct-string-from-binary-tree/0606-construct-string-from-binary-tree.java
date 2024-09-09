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
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        
        traversePreorder(root, result);
        
        return result.toString();
    }
    
    private void traversePreorder(TreeNode node, StringBuilder result) {
        result.append(node.val);
        
        if (node.left != null)
        {
            result.append("(");
            traversePreorder(node.left, result);
            result.append(")");
        }

        if (node.left == null && node.right != null)
        {
            result.append("()");
        }

        if (node.right != null)
        {
            result.append("(");
            traversePreorder(node.right, result);
            result.append(")");
        }
        
    }
}