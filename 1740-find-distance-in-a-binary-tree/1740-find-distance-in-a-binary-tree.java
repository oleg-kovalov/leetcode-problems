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
        record NeighWDist(Integer value, Integer distance) {}
        record AdjPair(int node1, int node2) {}
        List<AdjPair> adjMatrix;

        public int findDistance(TreeNode root, int p, int q)
        {

            if (p == q) return 0;
            
            adjMatrix = new ArrayList<>();
            dfsPostOrder(root);

            LinkedList<NeighWDist> neighbours = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (final AdjPair pair : adjMatrix)
            {
                if (pair.node1 == p)
                {
                    neighbours.offer(new NeighWDist(pair.node2, 1));
                }
            }

            while (neighbours.size() > 0)
            {
                NeighWDist current = neighbours.poll();
                int currentVal = current.value;
                if (visited.contains(currentVal))
                {
                    continue;
                }

                int distance = current.distance;
                if (currentVal == q)
                {
                    return distance;
                }

                visited.add(currentVal);
                for (final AdjPair pair : adjMatrix)
                {
                    if (pair.node1 == currentVal)
                    {
                        neighbours.offer(new NeighWDist(pair.node2, distance+1));
                    }
                }

            }

            return -1;

        }

        private void dfsPostOrder(TreeNode current)
        {
            if (current == null) return;

            dfsPostOrder(current.left);
            dfsPostOrder(current.right);

            if (current.left != null)
            {
                adjMatrix.add(new AdjPair(current.val, current.left.val));
                adjMatrix.add(new AdjPair(current.left.val, current.val));
            }
            if (current.right != null)
            {
                adjMatrix.add(new AdjPair(current.val, current.right.val));
                adjMatrix.add(new AdjPair(current.right.val, current.val));
            }
        }
    }