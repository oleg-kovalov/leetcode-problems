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
    public int maxLevelSum(TreeNode root) {

        int maxSumLevel = 0; // 1
        int maxSum = Integer.MIN_VALUE; //-100

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int size = queue.size(); //0
        int level = 1; // 2
        int sum = 0; // -500
        while (queue.size() > 0)
        {
            TreeNode node = queue.poll();

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            sum += node.val; 
            size -= 1;
            if (size == 0)
            {
                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumLevel = level;
                }
                sum = 0;
                level += 1;
                size = queue.size();
            }
        }

        return maxSumLevel;
    }
}