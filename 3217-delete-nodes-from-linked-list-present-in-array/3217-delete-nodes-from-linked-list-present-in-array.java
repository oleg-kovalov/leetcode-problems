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
    public ListNode modifiedList(int[] nums, ListNode head)
    {
        Set<Integer> excludeSet = new HashSet<>();
        for (int num: nums)
        {
            excludeSet.add(num);
        }
        
        ListNode resultHead = head;
        while (resultHead != null && excludeSet.contains(resultHead.val))
        {
            resultHead = resultHead.next;
        }
        
        if (resultHead == null) return null;

        ListNode current = resultHead;
        while (current.next != null)
        {
            ListNode next = current.next;
            if (excludeSet.contains(next.val))
            {
                current.next = next.next;
            } else {
                current = current.next;
            }

        }

        return resultHead;

    }
}