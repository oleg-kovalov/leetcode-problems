class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num: nums)
        {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k)
        {
            minHeap.offer(val);
        } else {
            if (minHeap.peek() < val)
            {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */