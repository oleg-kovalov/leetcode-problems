class Solution {
        public boolean validTree(int n, int[][] edges) {
            // fully connected graph without cycles must have exactly n-1 edges
            if (edges.length != n-1)
            {
                return false;
            }

            //ensure graph has no cycles
            // start with single-node graphs
            // {0}, {1}, {2}, {3}
            // adding each edge must result in graphs merge
            // [0->1] => {0,1}, {2}, {3}
            // [2->0] => {0,1,2}, {3}
            // if adding edge doesn't result in graphs merge, this is cycle
            // [1->2] => {0,1,2}, {3}
            UnionFindOptimized unionFind = new UnionFindOptimized(n, edges);
            for (int[] edge : edges) {
                boolean union = unionFind.unionByRank(edge[0], edge[1]);
                if (!union){
                    return false;
                }
            }

            return true;
        }

        class UnionFindOptimized {

            private int[] parent;
            private int[] rank; //height of subtree
            private int[] size; // # of elements in subtree

            UnionFindOptimized(int n, int[][] edges)
            {
                parent = new int[n];

                rank = new int[n];
                size = new int[n];

                for (int i = 0; i < n; i++) {
                    parent[i] = i;

                    rank[i] = 1;
                    size[i] = 1;
                }
            }

            // move each node, met along the way directly under parent, once it's resolved
            int findWithPathCompression(int node)
            {
                int parentNode = node;
                while (parentNode != parent[parentNode] )
                {
                    parentNode = parent[parentNode];
                }

                int currentNode = node;
                while (currentNode != parentNode)
                {
                    int oldParentNode = parent[currentNode];
                    parent[currentNode] = parentNode;
                    currentNode = oldParentNode;
                }

                return parentNode;
            }

            // return true of union happens
            // when union, merge smaller set into larger
            boolean unionBySize(int nodeA, int nodeB)
            {
                int rootA = findWithPathCompression(nodeA);
                int rootB = findWithPathCompression(nodeB);

                if (rootA == rootB) {
                    // cycle detected
                    return false;
                }

                if (size[rootA] > size[rootB])
                {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                } else {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }

                return true;
            }

            // return true of union happens
            // when union, merge lower subtree into higher. If same, merge any and increase rank+1
            boolean unionByRank(int nodeA, int nodeB)
            {
                int rootA = findWithPathCompression(nodeA);
                int rootB = findWithPathCompression(nodeB);

                if (rootA == rootB) {
                    // cycle detected
                    return false;
                }

                if (rank[rootA] > rank[rootB])
                {
                    parent[rootB] = rootA;
                }
                else if (rank[rootA] > rank[rootB])
                {
                    parent[rootA] = rootB;
                }
                else
                {
                    parent[rootA] = rootB;
                    rank[rootB]++;
                }

                return true;
            }

        }
    }

