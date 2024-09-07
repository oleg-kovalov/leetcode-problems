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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0)
        {
            TreeNode treeNode = queue.poll();
            if (treeNode.val == head.val)
            {
                if (followPath(treeNode, head)) return true;
            }
            
            if (treeNode.left != null) queue.offer(treeNode.left);
            if (treeNode.right != null) queue.offer(treeNode.right);
        }

        return false;
    }
    
    private boolean followPath(TreeNode treeNode, ListNode listNode)
    {
        if (listNode == null) return true;
        if (treeNode == null) return false;
        if (treeNode.val != listNode.val) return false;

        return followPath(treeNode.left, listNode.next)
            || followPath(treeNode.right, listNode.next);
    }
}