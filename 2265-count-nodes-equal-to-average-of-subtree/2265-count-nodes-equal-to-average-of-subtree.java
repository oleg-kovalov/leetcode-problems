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
    private int result = 0;

    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeDFS(root);
        
        return result;
    }

    public int[] averageOfSubtreeDFS(TreeNode node) {
        if (node == null) return new int[] {0,0};

        int[] resultL = averageOfSubtreeDFS(node.left);
        int[] resultR = averageOfSubtreeDFS(node.right);

        int sum = resultL[0] + resultR[0] + node.val; 
        int count = resultL[1] + resultR[1] + 1;
        
        if (node.val == sum/count) {
            result++;
        }
        
        return new int[]{sum, count};
    }

}