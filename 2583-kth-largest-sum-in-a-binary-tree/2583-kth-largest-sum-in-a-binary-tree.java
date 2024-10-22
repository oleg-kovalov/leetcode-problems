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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int lvlCount = 1;
        long lvlSum = 0;
        int nextCount = 0;
        while (queue.size() > 0)
        {
            TreeNode current = queue.poll();
            lvlCount--;
            lvlSum += current.val;

            if (current.left != null) {
                queue.offer(current.left);
                nextCount++;
            }
            if (current.right != null)
            {
                queue.offer(current.right);
                nextCount++;
            }

            if (lvlCount == 0)
            {
                maxHeap.offer(lvlSum);
                lvlCount = nextCount;
                nextCount = 0;
                lvlSum = 0;
            }
        }

        if (maxHeap.size() < k) return -1;

        for (int i=1; i<k; i++)
        {
            maxHeap.poll();
        }

        return maxHeap.poll();

    }
}