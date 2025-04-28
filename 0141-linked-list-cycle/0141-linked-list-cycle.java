/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> seen = new HashSet<>();

        ListNode curr = head;
        while (curr != null)
        {
            if (seen.contains(curr)) return true;

            seen.add(curr);
            curr = curr.next;
        }

        return false;
    }
}