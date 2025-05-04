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
        public ListNode mergeKLists(ListNode[] lists)
        {
            int interval = 1;
            while (interval < lists.length)
            {
                for (int i=0; i < lists.length; i += 2 * interval)
                {
                    lists[i] = mergeLists(lists[i], 
                        i + interval < lists.length ? lists[i + interval] : null);
                }
                
                interval *= 2;
            }
            
            return lists.length == 0 ? null : lists[0];
        }

        private ListNode mergeLists(ListNode left, ListNode right)
        {
            ListNode head = new ListNode();
            ListNode curr = head;
            while (left != null || right != null)
            {
                if (left == null) {
                    curr.next = right;
                    right = right.next;
                } else if (right == null)
                {
                    curr.next = left;
                    left = left.next;
                } else {
                    if (left.val <= right.val)
                    {
                        curr.next = left;
                        left = left.next;
                    } else {
                        curr.next = right;
                        right = right.next;
                    }
                }
                curr = curr.next;
            }
            
            return head.next;
        }
}