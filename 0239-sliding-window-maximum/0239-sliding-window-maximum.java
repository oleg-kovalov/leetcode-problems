class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        int[] result = new int[nums.length - (k - 1)]; 

        for (int i=0; i<k; i++)
        {
            maxHeap.offer(new int[] {nums[i], i});
        }

        result[0] = maxHeap.peek()[0];

        int left = 1;
        while (left + k - 1 < nums.length)
        {
            maxHeap.offer(new int[] {nums[left + k - 1], left + k - 1});

            while (maxHeap.peek()[1] < left) 
            {
                maxHeap.poll();
            }

            result[left] = maxHeap.peek()[0];
            left += 1;
        }

        return result;

    }
}