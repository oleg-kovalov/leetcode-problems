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
    public TreeNode createBinaryTree(int[][] descriptions)
    {
        Set<TreeNode> hasParent = new HashSet<>();
        Map<Integer, TreeNode> nodes = new HashMap<>();

        for (final int[] description : descriptions)
        {
            int val = description[0];
            TreeNode parent = nodes.getOrDefault(val, new TreeNode(val));

            int valChild = description[1];
            boolean isLeft = description[2] == 1;
            TreeNode left =  isLeft ? nodes.getOrDefault(valChild, new TreeNode(valChild)) : null;
            TreeNode right =  isLeft ? null : nodes.getOrDefault(valChild, new TreeNode(valChild));


            if (left != null)
            {
                parent.left = left;
                nodes.put(left.val, left);
                hasParent.add(left);
            }
            if (right != null)
            {
                parent.right = right;
                nodes.put(right.val, right);
                hasParent.add(right);
            }

            nodes.put(parent.val, parent);
        }

        for (final TreeNode node : nodes.values())
        {
            if (!hasParent.contains(node)) return node;
        }

        return null;
    }
}