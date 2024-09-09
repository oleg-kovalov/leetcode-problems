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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null) return result;

        TreeNode prevNode = null;
        TreeNode currNode = root;
        while (!(currNode == null && stack.isEmpty()))
        {
            if (currNode != null)
            {
                stack.push(currNode);
                currNode = currNode.left;
            }
            else
            {
                currNode = stack.peek();

                if (currNode.right == null || currNode.right == prevNode)
                {
                    result.add(currNode.val);
                    stack.pop();
                    prevNode = currNode;
                    currNode = null; // ensire we don't traverse again from this node
                }
                else 
                {
                    currNode = currNode.right;
                }
            }
        }

        return result;
    }
}