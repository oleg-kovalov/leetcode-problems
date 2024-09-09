class Solution {
        public int maximumPopulation(int[][] logs)
        {
            Arrays.sort(logs, (a,b) -> a[0] - b[0]);
            
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int maxPopulation = 0;
            int maxPopulationYear = 0;
            for (int[] log : logs)
            {
                while (minHeap.peek() != null && minHeap.peek() <= log[0])
                {
                    minHeap.poll();
                }
                minHeap.offer(log[1]);
                
                if (minHeap.size() > maxPopulation)
                {
                    maxPopulation = minHeap.size();
                    maxPopulationYear = log[0];
                }
            }
            
            return maxPopulationYear;
        }
}