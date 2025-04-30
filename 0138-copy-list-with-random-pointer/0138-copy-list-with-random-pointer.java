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

        Node curr = dummy;
        Node curr2 = dummy2;
        while(curr != null)
        {
            curr = curr.next;
            curr2.next = (curr == null ? null : new Node(curr.val));
            curr2 = curr2.next;
        }

        Node source1 = dummy;
        Node source2 = dummy2;

        while (source1.next != null)
        {
            source1 = source1.next;
            source2 = source2.next;

            Node target = source1.random;
            if (target == null) 
            {
                source2.random = null;
            } else {
                Node target1 = dummy;
                Node target2 = dummy2;
                while (target1 != target)
                {
                    target1 = target1.next;
                    target2 = target2.next;
                }
                source2.random = target2;
            }
        }
        


        // Node print = dummy2;
        // while (print != null)
        // {
        //     print = print.next;
        //     System.out.print(print == null ? null : print.val + " -> ");
        // }

        return dummy2.next;

    }
}