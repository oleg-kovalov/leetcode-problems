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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int size = queue.size();                
        while (queue.size() > 0)
        {
            TreeNode node = queue.poll();

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            size -= 1;
            if (size == 0)
            {
                // we are at the end of level
                result.add(node.val);
                size = queue.size();
            }
        }

        return result;

    }
}