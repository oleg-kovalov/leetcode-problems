class Solution {


    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        boolean[][] adjMatrix = new boolean[n][n];

        for (int i=0; i<n-1; i++)
        {
            adjMatrix[i][i+1] = true;
        }

        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++)
        {
            adjMatrix[queries[i][0]][queries[i][1]] = true;

            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
            for (int col=0; col < n; col++)
            {
                if (adjMatrix[0][col])
                {
                    minHeap.offer(new int[]{1, col});
                }
            }

            while (minHeap.size() > 0)
            {
                int[] vertex = minHeap.poll();
                if (vertex[1] == n - 1) 
                {
                    result[i] = vertex[0];
                    break;
                }

                for (int col=0; col < n; col++)
                {
                    if (adjMatrix[vertex[1]][col]) 
                        minHeap.offer(new int[] {vertex[0] + 1, col});
                }
            }
        }

        return result;
    }
}