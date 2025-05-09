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
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> levelResult = new ArrayList<>();
        int size = queue.size();
        while (queue.size() > 0)
        {
            TreeNode node = queue.poll();
            levelResult.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            size -= 1;
            if (size == 0)
            {
                result.add(levelResult);
                levelResult = new ArrayList<>();
                size = queue.size();
            }
        }

        return result;
    }
}