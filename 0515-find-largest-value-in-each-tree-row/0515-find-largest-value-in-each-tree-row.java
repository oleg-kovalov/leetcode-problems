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
     public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sizeCurrentRow = queue.size();
        int maxCurrentRow = Integer.MIN_VALUE;

        while (queue.size() > 0) {
            final TreeNode current = queue.poll();

            if (current.left != null)
            {
                queue.add(current.left);
            }

            if (current.right != null)
            {
                queue.add(current.right);
            }

            // System.out.print(" " + current.val + " ");

            sizeCurrentRow--;
            if (maxCurrentRow < current.val)
            {
                maxCurrentRow = current.val;
            }


            if (sizeCurrentRow == 0)
            {
                result.add(maxCurrentRow);
                sizeCurrentRow = queue.size();
                maxCurrentRow = Integer.MIN_VALUE;
            }

        }

        return result;
    }
}