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
    record NodePair (TreeNode node, int max) {};
    public int goodNodes(TreeNode root) {

        int count = 0;
        LinkedList<NodePair> queue = new LinkedList<>();
        queue.offer(new NodePair(root, root.val));

        while (queue.size() > 0)
        {
            NodePair pair = queue.poll();
            TreeNode node = pair.node();

            if (node.val >= pair.max())
            {
                count += 1;
            }

            int newMax = Math.max(node.val, pair.max());

            if (node.left != null) queue.offer(new NodePair(node.left, newMax));
            if (node.right != null) queue.offer(new NodePair(node.right, newMax));
        }

        return count;
    

    }
}