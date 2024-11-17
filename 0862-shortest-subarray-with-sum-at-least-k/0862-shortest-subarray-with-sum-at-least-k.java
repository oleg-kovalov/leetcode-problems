class Solution {
    public int shortestSubarray(int[] nums, int k) {


        int result = Integer.MAX_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int rollingSum = 0;

        for (int i=0; i<nums.length; i++)
        {
            rollingSum += nums[i];
            if (rollingSum >= k) result = Math.min(result, i+1);
            
            while (minHeap.peek() != null && rollingSum - minHeap.peek()[0] >= k)
            {
                result = Math.min(result, i - minHeap.poll()[1]);
            }

            minHeap.offer(new int[] {rollingSum, i});

        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}