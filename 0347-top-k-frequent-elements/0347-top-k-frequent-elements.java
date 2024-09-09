class Solution {
    record FreqPair(int val, int freq) {}

    public int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (final int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }


        final PriorityQueue<FreqPair> maxHeap = new PriorityQueue<>(Comparator.comparing(FreqPair::freq).reversed());
        for (final Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            maxHeap.offer(new FreqPair(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
        {
            result[i] = maxHeap.poll().val;
        }


        return result;
    }
}
