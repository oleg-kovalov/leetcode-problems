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
    HashMap<Integer, List<Integer>> adjacencyList;
    Set<Integer> visited = new HashSet<>();
    public int amountOfTime(TreeNode root, int start) {
                if (root.left == null && root.right == null) return 0;

        adjacencyList  = new HashMap<>();
        adjacencyList.put(root.val, new ArrayList<>());
        dfs(root);

        Set<Integer> neighboursToVisit = new HashSet<>();
        neighboursToVisit.add(start);
        int time = -1;
        while (neighboursToVisit.size() > 0)
        {
            Set<Integer> neighboursVisiting = neighboursToVisit;
            neighboursToVisit = new HashSet<>();
            for (Integer neighbour : neighboursVisiting) {
                if (!visited.contains(neighbour))
                {
                    visited.add(neighbour);
                    neighboursToVisit.addAll(adjacencyList.get(neighbour));
                }

            }
            time++;
        }


        return time-1;

    }

    private void dfs (TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        int currentVal = node.val;

        if (node.left != null)
        {
            int leftVal = node.left.val;
            adjacencyList.get(currentVal).add(leftVal);
            List<Integer> leftList = new ArrayList<>();
            leftList.add(currentVal);
            adjacencyList.put(leftVal, leftList);

            dfs(node.left);
        }
        if (node.right != null)
        {
            int rightVal = node.right.val;
            adjacencyList.get(currentVal).add(rightVal);
            List<Integer> rightList = new ArrayList<>();
            rightList.add(currentVal);
            adjacencyList.put(rightVal, rightList);

            dfs(node.right);
        }



    }
}