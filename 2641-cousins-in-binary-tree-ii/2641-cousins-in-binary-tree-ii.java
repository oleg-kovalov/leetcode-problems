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
    List<Integer> sums = new ArrayList<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.size() > 0)
        {
            int lvlCount = queue.size();
            int lvlSum = 0;
            for (int i=lvlCount; i> 0; i--)
            {
                TreeNode curr = queue.poll();
                lvlSum += curr.val;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            sums.add(lvlSum);
        }

        dfs(root, 0);
        root.val = 0;

        return root;
    }

    private int dfs(TreeNode curr, int lvl)
    {
        if (curr.left == null && curr.right == null) return curr.val;

        int childSum = 0;
        if (curr.left != null) {
            childSum += dfs(curr.left, lvl + 1);
        }
        if (curr.right != null) {
            childSum += dfs(curr.right, lvl + 1);
        }

        int cousinsSum = sums.get(lvl+1) - childSum;
        if (curr.left != null)
        {
            curr.left.val = cousinsSum;
        } 
        if (curr.right != null)
        {
            curr.right.val = cousinsSum;
        }

        return curr.val;
    }
}