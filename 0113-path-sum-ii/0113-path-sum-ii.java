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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new ArrayList<>());

        return result;
    }

    private void traverse(TreeNode root, int targetSum, List<Integer> path) // 3 , 5, [2, 3]
    {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null)
        {
            if (targetSum - root.val == 0)
            {
                result.add(new ArrayList<>(path));
            }
        } else {
            traverse(root.left, targetSum - root.val, path);
            traverse(root.right, targetSum - root.val, path);
        }
        path.remove(path.size() - 1);
    }
}