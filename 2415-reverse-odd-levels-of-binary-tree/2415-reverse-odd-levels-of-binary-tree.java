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
    public TreeNode reverseOddLevels(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean odd = true;
        while (queue.size() > 0)
        {
            int length = queue.size();
            odd = !odd;

            List<TreeNode> nodes = new ArrayList<TreeNode>();

            for (int i=0; i<length; i++)
            {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            
                if (odd)
                {
                    nodes.add(node);
                }
            }

            if (nodes.size() > 0)
            {
                for (int i=0; i<length /2; i++)
                {
                    int tmp = nodes.get(i).val;
                    nodes.get(i).val = nodes.get(length - 1 - i).val;
                    nodes.get(length - 1 - i).val = tmp;
                }
            }

        }

        return root;

    }
}