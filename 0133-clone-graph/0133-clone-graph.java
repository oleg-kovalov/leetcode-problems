/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        HashMap<Node,Node> cloned = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (queue.size() > 0)
        {

            Node oldNode = queue.poll();
            if (cloned.containsKey(oldNode)) continue;


            Node newNode = new Node(oldNode.val);
            cloned.put(oldNode, newNode);

            for (Node neighbor: oldNode.neighbors)
            {
                if (cloned.containsKey(neighbor))
                {
                    Node newNeighbor = cloned.get(neighbor);
                    newNode.neighbors.add(newNeighbor);
                    newNeighbor.neighbors.add(newNode);
                } else {
                    queue.offer(neighbor);
                }
            }
        }
        
        return cloned.get(node);

    }
}









// DFS
//
// class Solution {
//     HashMap<Node, Node> created = new HashMap<>();

//     public Node cloneGraph(Node node) {
//         if (node == null) return null;
//         Node newNode = new Node(node.val);
//         created.put(node, newNode);
//         for (Node neighbor: node.neighbors)
//         {
//             if (created.containsKey(neighbor))
//             {
//                 newNode.neighbors.add(created.get(neighbor));
//             } else {
//                 newNode.neighbors.add(cloneGraph(neighbor));
//             }
//         }

//         return newNode;
//     }
// }