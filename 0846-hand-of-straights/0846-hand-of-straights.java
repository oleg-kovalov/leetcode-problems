class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) return false;
        int numGroups = hand.length / groupSize;

        Arrays.sort(hand);

        // highest card, size
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        minHeap.offer(new int[] {hand[0], 1});
        int groupCount = 1;


        for (int i=1; i<hand.length; i++)
        {
            int num = hand[i];

            int[] group = minHeap.peek();
            if (group != null && group[0] == num - 1) {
                minHeap.poll();
                if (group[1] + 1 < groupSize) {
                    minHeap.offer(new int[] {num, group[1] + 1});
                }
            } else if (groupCount < numGroups)
            {
                minHeap.offer(new int[] {num, 1});
                groupCount += 1;
            } else {
                return false;
            }
        }

        return true;
        
    }
}