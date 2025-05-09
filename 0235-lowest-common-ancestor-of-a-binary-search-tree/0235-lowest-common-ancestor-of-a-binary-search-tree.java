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
        findPath(root, p, pathP);

        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root, q, pathQ);


        // System.out.println(pathP.stream().map(n -> n.val).toList());
        // System.out.println(pathQ.stream().map(n -> n.val).toList());
        TreeNode result = root;
        for (int i=0; i<Math.min(pathP.size(), pathQ.size()) && pathP.get(i) == pathQ.get(i); i++)
        {
            result = pathP.get(i);
        }

        return result;
    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path)
    {
        if (root == null) return false;

        path.add(root);

        if (root.val == target.val) return true;

        if (findPath(root.left, target, path)) return true;
        if (findPath(root.right, target, path)) return true;

        path.remove(path.size()-1);
        return false;
    }
}