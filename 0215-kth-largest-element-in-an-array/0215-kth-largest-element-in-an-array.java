class Solution {
    public int findKthLargest(int[] nums, int k) {
        // priority queue based on min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int num : nums) {
            priorityQueue.add(num);
            // keep only k largest elements
            if (priorityQueue.size() > k)
            {
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();
    }
}