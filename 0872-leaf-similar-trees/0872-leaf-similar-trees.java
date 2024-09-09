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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        traverseRec(root1, leafs1);

        List<Integer> leafs2 = new ArrayList<>();
        traverseRec(root2, leafs2);

        return leafs1.equals(leafs2);
    }

    private void traverseRec(TreeNode node, List<Integer> leafs)
    {
        if (node == null)
        {
            return;
        }
        if (node.left == null && node.right == null)
        {
            leafs.add(node.val);
            return;
        }
        
        traverseRec(node.left, leafs);
        traverseRec(node.right, leafs);
    }
}