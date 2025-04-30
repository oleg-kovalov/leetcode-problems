/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
    
        Node dummy = new Node(-1);
        dummy.next = head;

        Node dummy2 = new Node(-1);

        HashMap<Node, Node> nodes = new HashMap<>();

        Node curr = dummy;
        Node curr2 = dummy2;
        while (curr != null)
        {
            if (curr.next == null)
            {
                curr2.next = null;
            } else {
                curr2.next = new Node(curr.next.val);
                nodes.put(curr.next, curr2.next);
            }
            curr = curr.next;
            curr2 = curr2.next;
        }

        curr = dummy.next;
        while (curr != null)
        {
            Node target = curr.random;
            nodes.get(curr).random = nodes.get(target);
            curr = curr.next;
        }


        return dummy2.next;

    }
}