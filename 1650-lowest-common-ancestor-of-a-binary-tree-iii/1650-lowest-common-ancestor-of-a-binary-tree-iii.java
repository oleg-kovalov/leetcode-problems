/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> pParents = new HashSet<>();
        
        Node curr = p;
        pParents.add(curr);
        while (curr.parent != null)
        {
            curr = curr.parent;
            pParents.add(curr);
        }

        curr = q;
        while (curr.parent != null)
        {
            if (pParents.contains(curr)) return curr; 
            curr = curr.parent;
        }

        return curr;
    }

}