class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] starts = new int[26];
        Arrays.fill(starts, -1);

        int[] ends = new int[26];
        Arrays.fill(ends, -1);

        for (int i=0; i<s.length(); i++)
        {
            int c = s.charAt(i) - 'a';

            if (starts[c] == -1) starts[c] = i;
            ends[c] = i;
        }


        List<Integer> result = new ArrayList<>();

        // start idx, letter
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<starts.length; i++)
        {
            if (starts[i] == -1) continue;
            
            minHeap.offer(new int[] {starts[i], i});
        }       

        int offset = -1;
        int partitionEnd = -1;
        while (minHeap.size() > 0)
        {
            int[] entry = minHeap.poll();
            int start = entry[0], letter = entry[1];

            if (partitionEnd != -1 && start > partitionEnd)
            {
                result.add(partitionEnd - offset);
                offset += (partitionEnd - offset);
            }
            int end = ends[letter];
            partitionEnd = Math.max(partitionEnd, end);
        }

        result.add(partitionEnd - offset);

        return result;
    }
}