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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = traverseRec(root, low, high);

        return sum;
    }

    private int traverseRec(TreeNode node, int low, int high)
    {
        if (node == null) return 0;
        int current = node.val;

        int currentSum = 0;
        if (low <= current && current <= high){
            currentSum += current;
        }
        if (current > low)
        {
            currentSum += traverseRec(node.left, low, high);
        }
        if (current < high)
        {
            currentSum += traverseRec(node.right, low, high);
        }

        return currentSum;
    }

}