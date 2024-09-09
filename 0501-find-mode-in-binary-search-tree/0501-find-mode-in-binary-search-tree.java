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

    private int maxStreak = 0;
    private int currentStreak = 0;
    private int currentNum = 0;
    private ArrayList<Integer> result = new ArrayList<>();


    public int[] findMode(TreeNode root) {
        findModeInOrder(root);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void findModeInOrder(TreeNode node)
    {
        if (node == null) return;

        findModeInOrder(node.left);

        final int val = node.val;
        if (val == currentNum)
        {
            currentStreak +=1;
        } else {
            currentNum = val;
            currentStreak = 1;
        }
        
        if (currentStreak == maxStreak)
        {
            result.add(val);
        } else if (currentStreak > maxStreak) {
            result.clear();
            maxStreak = currentStreak;
            result.add(val);
        }
        
        findModeInOrder(node.right);
    }
    

}