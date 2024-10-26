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
    Map<Integer, Integer> nodeToDepth = new HashMap<>(); // depth of tree if node will be removed
    int maxDepth;
    public int[] treeQueries(TreeNode root, int[] queries) {
        maxDepth = 0;
        dfs(root, 0, true); //left to right
        maxDepth = 0;
        dfs(root, 0, false); //right to left

        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++)
        {
            result[i] = nodeToDepth.get(queries[i]);
        }
        return result;
    }

    private void dfs(TreeNode curr, int depth, boolean leftToRight)
    {
        if (curr == null) return;

        nodeToDepth.put(curr.val, 
            Math.max(Math.max(depth-1, maxDepth), nodeToDepth.getOrDefault(curr.val, 0))); //depth if we delete this node
        maxDepth = Math.max(maxDepth, depth);
        if (leftToRight)
        {
            dfs(curr.left, depth+1, leftToRight);
            dfs(curr.right, depth+1, leftToRight);
        } else {
            dfs(curr.right, depth+1, leftToRight);
            dfs(curr.left, depth+1, leftToRight);
        }

    }
}