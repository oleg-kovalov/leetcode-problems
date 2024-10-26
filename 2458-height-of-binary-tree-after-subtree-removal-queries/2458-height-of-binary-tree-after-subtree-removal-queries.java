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
    Map<Integer, List<Integer>> heightToNode = new TreeMap<>(Comparator.reverseOrder());
    Map<Integer, Integer> nodeToParent = new HashMap<>();
    Map<Integer, Boolean> nodeToActive = new HashMap<>(); 
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, -1, 0);    
        int[] result = new int[queries.length];

        for (int i=0; i<queries.length; i++)
        {
            int query = queries[i];

            for (int node: nodeToActive.keySet())
            {
                // restore tree before next query
                nodeToActive.put(node, true);
            }
            nodeToActive.put(query, false);

            for (Map.Entry<Integer, List<Integer>> entry: heightToNode.entrySet())
            {
                for (Integer node: entry.getValue())
                {
                    List<Integer> parents = new ArrayList<>();
                    while (node != -1 && nodeToActive.get(node))
                    {
                        parents.add(node);
                        node = nodeToParent.get(node);
                    }
                    if (node == -1)
                    {
                        // all nodes up to root are active, we have the result
                        result[i] = entry.getKey();
                        break;
                    } else 
                    {
                        // there an inactive node among parents
                        // we make all visited nodes inactive as well
                        for (int parent: parents)
                        {
                            nodeToActive.put(parent, false);
                        }
                    }
                }
                if (result[i] > 0) break;
            }
        }

        return result;
    }

    private void dfs(TreeNode curr, int parent, int height)
    {
        if (curr == null) {
            return;
        }

        if (!heightToNode.containsKey(height))
        {
            heightToNode.put(height, new ArrayList<>());
        }
        heightToNode.get(height).add(curr.val);
        nodeToParent.put(curr.val, parent);
        nodeToActive.put(curr.val, true);

        dfs(curr.left, curr.val, height+1);
        dfs(curr.right, curr.val, height+1);
    }


}