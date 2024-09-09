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

    public int[] nodesBetweenCriticalPoints(ListNode head)
    {
        ListNode prev = head;
        ListNode curr = head.next;

        int nodeId = 1;
        int earliestCP = -1;
        int latestCP = -1;

        int maxDistance = -1;
        int minDistance = -1;


        while (curr.next != null)
        {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
            (curr.val < prev.val && curr.val < curr.next.val))
            {
                // first critical point
                if (earliestCP == -1 && latestCP == -1)
                {
                    earliestCP = nodeId;
                    latestCP = nodeId;
                }
                else
                {
                    maxDistance = nodeId - earliestCP;
                    minDistance = minDistance == -1 
                        ? nodeId - latestCP
                        : Math.min(minDistance, nodeId - latestCP);

                    latestCP = nodeId;
                }
            }

            prev = curr;
            curr = curr.next;
            nodeId += 1;
        }

        return new int[]{minDistance, maxDistance};
    }
}