class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums; 

        // O(N)
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // O(N logK)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer,Integer> entry : freq.entrySet())
        {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            
            if (minHeap.size() > k) minHeap.poll();
        }

        // O(K logK)
        int[] result = new int[k];
        for (int i=0; i<result.length; i++)
        {
            result[i] = minHeap.poll()[0];
        }

        return result;

    }
}