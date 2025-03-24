class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long num: nums)
        {
            minHeap.offer(num);
        }

        int result = 0;
        while(minHeap.peek() < k)
        {
            minHeap.offer(minHeap.poll() * 2 + minHeap.poll());
            result += 1;
        }

        return result;

    }
}