/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

        public List<Integer> postorder(Node root)
        {
            if (root == null) return Collections.emptyList();
            
            Set<Node> nodesWithChildrenProcessed = new HashSet<>();
            LinkedList<Node> stack = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            
            stack.push(root);
            while (stack.size() > 0)
            {
                final Node node = stack.peek();
                if (nodesWithChildrenProcessed.contains(node))
                {
                    result.add(node.val);
                    stack.pop();
                } else
                {
                    for (int i=node.children.size()-1; i >=0; i--)
                    {
                        stack.push(node.children.get(i));
                    }
                    nodesWithChildrenProcessed.add(node);
                }
            }
            
            return result;

        }
}