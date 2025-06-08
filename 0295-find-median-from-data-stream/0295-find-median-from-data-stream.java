class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a)); // for smaller values
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // for larger values
    // rules:
    // 1. Size of both heaps almost equal (can differ by one)
    //    always add to maxHeap, if it's now bigger, move top element to minHeap
    //
    // 2. Top of maxHeap is < than top of minHeap
    //    if it's >= , then swap top elements between heaps

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        // check rule 1
        if (maxHeap.size() > minHeap.size() + 1)
        {
            minHeap.offer(maxHeap.poll());
        }

        // check rule 2
        if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() >= minHeap.peek())
        {
            int tmp = minHeap.poll();
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(tmp);
        }
    }
    
    public double findMedian() {
        boolean odd = ((maxHeap.size() + minHeap.size()) % 2) == 1;
        if (odd){
            return maxHeap.size() > minHeap.size() 
                    ? maxHeap.peek() 
                    : minHeap.peek();
        } else {
            return (0.0 + maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */