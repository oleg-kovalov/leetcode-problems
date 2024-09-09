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


    List<TreeNode> roots;
    Set<Integer> deleteSet;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        roots = new ArrayList<>();

        deleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        findRootsDfsPrePostOrder(root, null);

        return roots;
    }

    private TreeNode findRootsDfsPrePostOrder(TreeNode oldCurrent, TreeNode newParent)
    {
        if (oldCurrent == null)
        {
            return null;
        }

        TreeNode newCurrent;
        if (deleteSet.contains(oldCurrent.val))
        {
            newCurrent = null;
        }
        else
        {
            newCurrent = new TreeNode(oldCurrent.val);
            if (newParent == null)
            {
                roots.add(newCurrent);
            }

        }

        TreeNode newLeft = findRootsDfsPrePostOrder(oldCurrent.left, newCurrent);
        TreeNode newRight = findRootsDfsPrePostOrder(oldCurrent.right, newCurrent);

        if (newCurrent != null && oldCurrent.left != null && !deleteSet.contains(oldCurrent.left.val))
        {
            newCurrent.left = newLeft;
        }
        if (newCurrent != null && oldCurrent.right != null && !deleteSet.contains(oldCurrent.right.val))
        {
            newCurrent.right = newRight;
        }

        return newCurrent;

    }
    
}
