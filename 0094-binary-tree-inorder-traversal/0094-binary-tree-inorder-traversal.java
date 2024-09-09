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
    private List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {

        result = new ArrayList<>();
        if (root == null) return result;

        traverse(root);
        return result;

    }
           
    void traverse(TreeNode root) {
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        TreeNode current = root;
        push(nodeStack, current);
        Set<TreeNode> visited = new HashSet<>();

        while (nodeStack.peek() != null)
        {
            current = nodeStack.peek();

            if (current.left != null && !visited.contains(current.left)) {
                push(nodeStack, current.left);
                continue;
            }

            result.add(current.val);
            visited.add(current);
            pop(nodeStack);


            if (current.right != null)
            {
                push(nodeStack, current.right);
                continue;
            }



        } 
    }
    
    private void push(LinkedList<TreeNode> stack, TreeNode node)
    {
        stack.push(node);
        // System.out.println("result: " + result + ", stack: " + stack.stream().map(tn -> String.valueOf(tn.val)).collect(Collectors.joining(" ")));
    }

    private void pop(LinkedList<TreeNode> stack)
    {
        stack.pop();
        // System.out.println("result: " + result + ", stack: " +  stack.stream().map(tn -> String.valueOf(tn.val)).collect(Collectors.joining(" ")));
    }

  
}