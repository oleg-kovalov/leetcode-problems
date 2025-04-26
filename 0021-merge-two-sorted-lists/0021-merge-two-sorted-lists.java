/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode();
        merge(fakeHead, list1, list2);

        return fakeHead.next;
    }


    private void merge(ListNode curr, ListNode node1, ListNode node2)
    {
        if (node1 == null && node2 == null) return;

        if (node1 == null)
        {
            curr.next = new ListNode(node2.val);
            merge(curr.next, node1, node2.next);
            return;
        }

        if (node2 == null)
        {
            curr.next = new ListNode(node1.val);
            merge(curr.next, node1.next, node2);
            return;
        }

        if (node1.val <= node2.val)
        {
            curr.next = new ListNode(node1.val);
            merge(curr.next, node1.next, node2);
        } else {
            curr.next = new ListNode(node2.val);
            merge(curr.next, node1, node2.next);
        }

    }
}