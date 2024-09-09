    class KthLargest {

        final int k;
        PriorityQueue<Integer> priorityQueue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(Comparator.naturalOrder()); // ASC, from smaller to larger
            for (int num : nums) {
                priorityQueue.add(num);
            }

            // we keep only k largest elements, sorted ASC
            while (priorityQueue.size() > k)
            {
                priorityQueue.poll();
            }

        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k)
            {
                priorityQueue.poll();
            }

            return priorityQueue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */