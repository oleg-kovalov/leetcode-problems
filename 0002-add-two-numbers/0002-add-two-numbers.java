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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> num = new ArrayList<>();

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null || curr2 != null)
        {
            int sum = (curr1 != null ? curr1.val : 0)
                   +  (curr2 != null ? curr2.val : 0);
            
            num.add(sum);
            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;      
        }

        int carry = 0;
        for (int i=0; i < num.size(); i++)
        {
            int n = num.get(i);
            num.set(i, (n + carry) % 10);
            
            carry = (n + carry) / 10;
        }


        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i=0; i<num.size(); i++)
        {
            curr.next = new ListNode(num.get(i));
            curr = curr.next;
        }

        if (carry > 0)
        {
            curr.next = new ListNode(carry);
        }

        return dummy.next; 
    }

}