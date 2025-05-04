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
        
        LinkedList<ListNode> queue = new LinkedList<>();
        for (ListNode node: lists)
        {
            queue.offer(node);
        }

        while (queue.size() > 1)
        {
            ListNode list1 = queue.poll();
            ListNode list2 = queue.poll();

            ListNode mergeHead = new ListNode(-1);
            merge(mergeHead, list1, list2);
            queue.offer(mergeHead.next);
        }

        return queue.poll();
    }


    private void merge(ListNode result, ListNode list1, ListNode list2)
    {
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null)
        {
            if (curr1.val < curr2.val)
            {
                result.next = curr1;
                curr1 = curr1.next;
            }
            else 
            {
                result.next = curr2;
                curr2 = curr2.next;
            }
            result = result.next;
        }

        result.next = (curr1 != null ? curr1 : curr2); 
    }
}