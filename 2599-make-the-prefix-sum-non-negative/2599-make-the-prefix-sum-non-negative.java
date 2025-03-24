class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long runningSum = 0;
        int moves = 0; 
        for (int num: nums)
        {
            if (num < 0)
            {
                minHeap.offer(num);
            }
            runningSum += num;
            if (runningSum < 0)
            {
                int moveCandidate = minHeap.poll();
                runningSum -= moveCandidate;
                moves += 1;
            }
        }

        return moves;      
    }
}