class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> 
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int i=0; i<nums.length; i++)
        {
            minHeap.offer(new int[] {nums[i], i});
        }

        for (int i=0; i<k; i++)
        {
            int[] curr = minHeap.poll();
            minHeap.offer(new int[] {curr[0] * multiplier, curr[1]});
            nums[curr[1]] = curr[0] * multiplier;
        }


        return nums;

    }
}