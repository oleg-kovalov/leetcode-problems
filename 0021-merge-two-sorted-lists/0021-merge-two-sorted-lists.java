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
    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2)
    {
        final ListNode resHead;
        if (listNode1 == null && listNode2 == null)
        {
            return null;
        }
        else if (listNode1 == null)
        {
            return listNode2;
        }
        else if (listNode2 == null)
        {
            return listNode1;
        }
        else if (listNode1.val < listNode2.val)
        {
            resHead = new ListNode(listNode1.val);
            mergeNode(listNode1.next, listNode2, resHead);
        }
        else {
            resHead = new ListNode(listNode2.val);
            mergeNode(listNode1, listNode2.next, resHead);
        }

        return resHead;

    }

    private void mergeNode (ListNode listNode1, ListNode listNode2, ListNode resNode)
    {
        if (listNode1 == null && listNode2 == null)
        {
            return;
        }
        else if (listNode1 == null)
        {
            resNode.next = new ListNode(listNode2.val);
            mergeNode(listNode1, listNode2.next, resNode.next);
        }
        else if (listNode2 == null)
        {
            resNode.next = new ListNode(listNode1.val);
            mergeNode(listNode1.next, listNode2, resNode.next);
        }
        else if (listNode1.val < listNode2.val)
        {
            resNode.next = new ListNode(listNode1.val);
            mergeNode(listNode1.next, listNode2, resNode.next);
        }
        else
        {
            resNode.next = new ListNode(listNode2.val);
            mergeNode(listNode1, listNode2.next, resNode.next);
        }

    }
}