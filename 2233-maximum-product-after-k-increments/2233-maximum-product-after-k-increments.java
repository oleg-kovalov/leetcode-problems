class Solution {
    public int maximumProduct(int[] nums, int k) {
        

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums){
            minHeap.offer(num);
        }

        for (int i=0; i<k; i++)
        {
            int num = minHeap.poll();
            minHeap.offer(num + 1);
        }

        int result = 1;
        while (minHeap.size() > 0)
        {
            result = (int)((1L * result * minHeap.poll()) % 1000_000_007);
            // result %= 1000_000_007;
        }

        return result;
    }
}