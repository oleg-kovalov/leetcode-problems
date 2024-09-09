class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int[] result = new int[queries.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i=0; i<queries.length; i++)
        {
            int obstacle = Math.abs(queries[i][0]) + Math.abs((queries[i][1]));
            maxHeap.offer(obstacle);

            if (maxHeap.size() < k)
            {
                result[i] = -1;
            } else if (maxHeap.size() == k)
            {
                result[i] = maxHeap.peek();
            }
            else {
                maxHeap.poll();
                result[i] = maxHeap.peek();
            }
        }

        return result;
    }
}