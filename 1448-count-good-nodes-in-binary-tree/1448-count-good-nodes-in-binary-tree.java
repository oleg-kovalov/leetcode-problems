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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int path)
    {
        if (node == null) return 0;

        int newPath = Math.max(path, node.val);

        return dfs(node.left, newPath) 
            + dfs(node.right, newPath) 
            + (node.val >= path ? 1 : 0); 
    }

    // BFS 

    // record NodePair (TreeNode node, int max) {};
    // public int goodNodes(TreeNode root) {

    //     int count = 0;
    //     LinkedList<NodePair> queue = new LinkedList<>();
    //     queue.offer(new NodePair(root, root.val));

    //     while (queue.size() > 0)
    //     {
    //         NodePair pair = queue.poll();
    //         TreeNode node = pair.node();

    //         if (node.val >= pair.max())
    //         {
    //             count += 1;
    //         }

    //         int newMax = Math.max(node.val, pair.max());

    //         if (node.left != null) queue.offer(new NodePair(node.left, newMax));
    //         if (node.right != null) queue.offer(new NodePair(node.right, newMax));
    //     }

    //     return count;
    // }
}