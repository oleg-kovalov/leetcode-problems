class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet dsu = new DisjointSet(n);

        int cycles = 0;
        for (int[] conn: connections)
        {
            if (!dsu.union(conn[0],conn[1]))
            {
                cycles += 1;
            }
        }

        int components = dsu.countComponents();

        return cycles >= (components - 1) ? (components - 1) : -1;


    }

    class DisjointSet
    {
        int[] parent;
        int[] rank;

        public DisjointSet(int n)
        {
            parent = new int[n];
            for (int i=0; i<n; i++)
            {
                parent[i] = i;
            }

            rank = new int[n];
        }

        public boolean union(int a, int b)
        {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return false;

            int rankA = rank[rootA];
            int rankB = rank[rootB];

            if (rankA < rankB)
            {
                parent[rootA] = rootB;            
            } else if (rankA > rankB)
            {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
                rank[rootB] += 1;
            }
            
            return true;
        }

        private int find(int curr)
        {
            if (parent[curr] == curr) return curr;

            int root = find(parent[curr]);
            parent[curr] = root;

            return root;
        }

        public int countComponents()
        {
            int count = 0;
            for (int i=0; i<parent.length; i++)
            {
                if (parent[i] == i) count++;
            }

            return count;
        }

    }
}