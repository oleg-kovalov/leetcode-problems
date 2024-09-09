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
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        // right, down, left, top
        int[][] directions = {
            {0, 1},
            {1,0},
            {0, -1},
            {-1,0}};

        int[] limits = {
            n, m, -1,0
        };

        int[][] matrix = new int[m][n];
        int cells = m * n;
        int direction = 0;
        int row = 0;
        int col = -1;
        ListNode node = head;

        while (cells > 0)
        {
            if (direction % 2 == 0 && col + directions[direction][1] == limits[direction]
                || direction % 2 == 1 && row + directions[direction][0] == limits[direction])
            {
                if (direction == 0 || direction == 1)
                {
                    limits[direction] -= 1;
                } else {
                    limits[direction] += 1;
                }

                direction = (direction + 1) % directions.length;
                continue;
            }

            row += directions[direction][0];
            col += directions[direction][1];

            matrix[row][col] = node != null ? node.val : -1;

            if (node != null) node = node.next;
            cells -= 1;
        }

        return matrix;
    }
}