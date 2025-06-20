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
            for (int i=1; i<=n; i++)
            {
                parents[i] = i;
            }
            sizes = new int[n + 1];
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
                sizes[parentB] += 1;
            } else if (sizeA > sizeB)
            {
                parents[parentB] = parentA;
                sizes[parentA] += 1;
            } else {
                parents[parentB] = parentA;
                sizes[parentA] += 1;
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