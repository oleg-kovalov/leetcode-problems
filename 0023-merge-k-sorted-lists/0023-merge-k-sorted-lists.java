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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node: lists)
        {
            if ( node != null) minHeap.offer(node);
        }

        ListNode head = new ListNode();
        ListNode curr = head;
        while (minHeap.size() > 0)
        {
            ListNode nextNode = minHeap.poll();
            if (nextNode.next != null)
            {
                minHeap.offer(nextNode.next);
            }
            curr.next = nextNode;
            curr = nextNode;
        }

        return head.next;
    }
}