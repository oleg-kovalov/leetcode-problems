class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char c: tasks)
        {
            freq[c - 'A'] += 1;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1])); 
        for (int label=0; label<freq.length; label++)
        {
            if (freq[label] > 0)
                minHeap.offer(new int[] {label, 1});
        }

        int result = 0;
        while (minHeap.size() > 0)
        {
            int[] task = minHeap.poll();
            int label = task[0];
            int time = task[1];

            result = Math.max(result + 1, time);
            
            freq[label] -= 1;
            if (freq[label] > 0) {
                minHeap.offer(new int[] {label, time + n + 1});
            }
        }

        return result;

    }
}