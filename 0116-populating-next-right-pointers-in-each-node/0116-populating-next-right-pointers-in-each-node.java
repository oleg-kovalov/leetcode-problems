/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        int size = queue.size();
        Node pointer = null;
        
        while (queue.size() > 0)
        {
            Node node = queue.poll();
            node.next = pointer;
            pointer = node;
            
            if (node.right != null)
            {
                queue.offer(node.right);
                queue.offer(node.left);
            }
            
            size -= 1;
            if (size == 0)
            {
                level += 1;
                size = queue.size();
                pointer = null;
            }
        }
        return root;
    }
}