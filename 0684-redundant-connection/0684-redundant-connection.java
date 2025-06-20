class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        DSU dsu = new DSU(edges.length);
        for (int[] edge: edges)
        {
            if (!dsu.join(edge[0], edge[1])) return edge;
        }

        return new int[0];

    }

    class DSU
    {
        int[] parents;
        int[] ranks;

        DSU(int n)
        {
            parents = new int[n + 1];
            for (int i=1; i<=n; i++)
            {
                parents[i] = i;
            }
            ranks = new int[n + 1];
        }

        public boolean join(int nodeA, int nodeB)
        {
            int parentA = find(nodeA);
            int parentB = find(nodeB);

            if (parentA == parentB) return false; //cycle

            int rankA = ranks[parentA];
            int rankB = ranks[parentB];

            if (rankA < rankB)
            {
                parents[parentA] = parentB;
            } else if (rankA > rankB)
            {
                parents[parentB] = parentA;
            } else {
                parents[parentB] = parentA;
                ranks[parentA] += 1;
            }

            return true;
        }

        public int find(int node)
        {
            int parent = parents[node];
            if (parent == node)
            {
                return parent;
            }

            int root = find(parent);
            parents[node] = root;

            return root;
        }
    }
}