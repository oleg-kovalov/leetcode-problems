class Solution {
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, Comparator.comparing(a -> a[0]));

        final UnionFind unionFind = new UnionFind(n);

        for (int log=0; log < logs.length; log++)
        {
            int timestamp = logs[log][0];
            int friend1 = logs[log][1];
            int friend2 = logs[log][2];

            unionFind.union(friend1, friend2);
            if (unionFind.singleSet())
                return timestamp;
        }

        return -1;

    }

    private class UnionFind
    {
        private int[] parent;
        private int[] rank;

        private UnionFind(int size)
        {
            parent = new int[size];
            rank = new int[size];

            for (int i=0; i<size; i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        private int find(int i)
        {
            if (parent[i] == i)
            {
                return i;
            }

            // path compression
            // move member directly under representative of the set
            int representative = find(parent[i]);
            parent[i] = representative;

            return representative;

        }

        private void union(int i, int j)
        {
            int repI = find(i);
            int repJ = find(j);

            if (repI == repJ) return;

            int rankI = rank[repI];
            int rankJ = rank[repJ];

            if (rankI < rankJ)
            {
                parent[repI] = repJ;
            }
            else if (rankJ < rankI)
            {
                parent[repJ] = repI;
            }
            else
            {
                parent[repJ] = repI;
                rank[repI] += 1;
            }

        }

        private boolean singleSet()
        {
            boolean parentFound = false;
            for (int i=0; i<parent.length; i++)
            {
                if (parent[i] == i)
                {
                    if (parentFound)
                    {
                        //second parent found - multiple disjoint sets
                        return false;
                    }
                    parentFound = true;
                }
            }

            return true;
        }
    }
}