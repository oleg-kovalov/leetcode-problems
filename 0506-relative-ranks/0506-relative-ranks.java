class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        // score, idx
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        for (int i=0; i<score.length; i++)
        {
            maxHeap.offer(new int[] {score[i], i});
        }

        String[] result = new String[score.length];
        int position = 1;
        while (maxHeap.size() > 0)
        {
            int[] pair = maxHeap.poll();            
            String label;
            if (position == 1)
            {
                label = "Gold Medal";
            } else if (position == 2)
            {
                label = "Silver Medal";
            } else if (position == 3)
            {
                label = "Bronze Medal";
            } else {
                label = String.valueOf(position);
            }

            result[pair[1]] = label;
            position += 1;
        }

        return result;

    }
}