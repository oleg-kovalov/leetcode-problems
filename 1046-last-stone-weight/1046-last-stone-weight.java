class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int stone: stones)
        {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1)
        {
            int smashResult = maxHeap.poll() - maxHeap.poll();
            if (smashResult > 0) 
                maxHeap.offer(smashResult);
        }

        return maxHeap.size() != 0 ? maxHeap.poll() : 0;
    }
}