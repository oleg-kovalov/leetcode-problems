class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (char c: tasks)
        {
            freq.put(c - 'A', freq.getOrDefault(c - 'A', 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1])); 
        for (int label: freq.keySet())
        {
            minHeap.offer(new int[] {label, 1});
        }

        int result = 0;
        while (minHeap.size() > 0)
        {
            int[] task = minHeap.poll();
            int label = task[0];
            int time = task[1];

            result = Math.max(result + 1, time);
            freq.put(label, freq.get(label) - 1);
            if (freq.get(label) == 0) 
            {
                freq.remove(label);
            } else {
                minHeap.offer(new int[] {label, time + n + 1});
            }
        }

        return result;

    }
}