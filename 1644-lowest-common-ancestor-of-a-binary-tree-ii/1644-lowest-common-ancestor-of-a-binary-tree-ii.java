/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pathP = new ArrayList<>();
        dfs(root, p.val, pathP);
        if (pathP.size() == 0) return null;

        List<TreeNode> pathQ = new ArrayList<>();
        dfs(root, q.val, pathQ);
        if (pathQ.size() == 0) return null;

        for (int i=0; i<Math.min(pathP.size(), pathQ.size()); i++)
        {
            if (pathP.get(i) != pathQ.get(i))
            {
                return pathP.get(i-1);
            }
        }

        return pathP.size() < pathQ.size() ? pathP.get(pathP.size()-1) : pathQ.get(pathQ.size() -1);
    }

    private List<TreeNode> dfs(TreeNode node, int target, List<TreeNode> path)
    {
        if (node == null) return path;
        if (path.size() > 0 && path.get(path.size()-1).val == target) return path;

        path.add(node);
        if (path.get(path.size()-1).val == target) return path;

        dfs(node.left, target, path);
        if (path.get(path.size()-1).val == target) return path;
        dfs(node.right, target, path);
        if (path.get(path.size()-1).val == target) return path;

        path.remove(path.size() - 1);
        return path;
    }
}