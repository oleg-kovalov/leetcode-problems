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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int nodesAtLevel = 1;
        List<Integer> levelList = new ArrayList<>();
        
        if (root == null) return result;

        while (queue.size() > 0)
        {
            final TreeNode node = queue.poll();
            nodesAtLevel -= 1;
            levelList.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            
            if (nodesAtLevel == 0)
            {
                result.add(levelList);
                levelList = new ArrayList<>();
                nodesAtLevel = queue.size();
            }
        }
        
        return result;

    }
}