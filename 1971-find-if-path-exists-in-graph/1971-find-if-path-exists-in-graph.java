class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointUnionSets unionSets = new DisjointUnionSets(n);
        for (int[] edge : edges) {
            unionSets.union(edge[0], edge[1]);
        }

        int sourceRep = unionSets.find(source);
        int destRep = unionSets.find(destination);

        return sourceRep == destRep;
    }

    private final class DisjointUnionSets
    {
        int[] parent;
        int[] rank;

        DisjointUnionSets(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i=0; i < n; i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x)
        {
            if (parent[x] == x)
            {
                return x;
            } else {
                int result =  find(parent[x]);

                // path compression - put parent[x] derectly under representative
                parent[x] = result;

                return result;
            }
        }

        void union(int x, int y)
        {
            int repX = find(x);
            int repY = find(y);

            if (rank[x] < rank[y])
            {
                parent[repX] = repY;
            }
            else if (rank[x] > rank[y])
            {
                parent[repY] = repX;
            } else {
                parent[repY] = repX;
                rank[x] = rank[x] + 1;
            }
        }
    }
}