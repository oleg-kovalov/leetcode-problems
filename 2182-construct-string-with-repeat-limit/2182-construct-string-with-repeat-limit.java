class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        int[] freq = new int[26];
        for (int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i) - 'a'] += 1;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for (int i=0; i<freq.length; i++)
        {
            if (freq[i] > 0)
                maxHeap.offer(new int[] {i, freq[i]});
        }    

        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 0)
        {
            int[] curr = maxHeap.poll();
            int currFreq = curr[1];
            while (currFreq > 0)
            {
                int limit = currFreq >= repeatLimit ? repeatLimit : currFreq;
                for (int i=0; i<limit; i++)
                {
                    result.append((char)('a' + curr[0]));
                }
                currFreq -= limit;
                if (currFreq > 0)
                {
                    int[] next = maxHeap.poll();
                    if (next == null) return result.toString();
                    
                    result.append((char)('a' + next[0]));
                    if (next[1] > 1)
                    {
                        maxHeap.offer(new int[] {next[0], next[1] - 1});
                    }
                }
            }
        }

        return result.toString();


    }
}