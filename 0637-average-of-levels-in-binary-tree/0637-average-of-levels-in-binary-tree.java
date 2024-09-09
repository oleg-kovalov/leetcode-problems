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
        public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        
        int nodesLevel = 1;
        int nodesLevelProcessed = 0;
        long sumLevel = 0;
        
        queue.offer(root);
        
        while (queue.size() > 0)
        {
            final TreeNode node = queue.poll();
            nodesLevelProcessed += 1;
            sumLevel += node.val;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            if (nodesLevelProcessed == nodesLevel)
            {
                result.add((double)sumLevel / nodesLevel);
                
                nodesLevel = queue.size();
                nodesLevelProcessed = 0;
                sumLevel = 0;
            }
        }
        
        return result;
    }

}