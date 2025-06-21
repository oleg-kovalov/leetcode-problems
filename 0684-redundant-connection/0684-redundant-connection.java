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
        int[] sizes;

        DSU(int n)
        {
            parents = new int[n + 1];
            sizes = new int[n + 1];
            for (int i=1; i < n+1; i++)
            {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public boolean join(int nodeA, int nodeB)
        {
            int parentA = find(nodeA);
            int parentB = find(nodeB);

            if (parentA == parentB) return false; //cycle

            int sizeA = sizes[parentA];
            int sizeB = sizes[parentB];

            if (sizeA < sizeB)
            {
                parents[parentA] = parentB;
                sizes[parentB] += sizes[parentA];
            } else if (sizeA > sizeB)
            {
                parents[parentB] = parentA;
                sizes[parentA] += sizes[parentB];
            } else {
                parents[parentB] = parentA;
                sizes[parentA] += sizes[parentB];
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