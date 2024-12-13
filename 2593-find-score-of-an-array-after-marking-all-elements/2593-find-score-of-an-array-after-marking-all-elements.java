class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> 
            a != b ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));


        for (int i=0; i<nums.length; i++)
        {
            minHeap.offer(new int[] {nums[i], i});
        }

        long result = 0L;
        while (minHeap.size() > 0)
        {
            int[] curr = minHeap.poll();
            int currId = curr[1];
            if (nums[currId] == -1) continue;
            
            result += curr[0];
            nums[currId] = -1;
            if (currId > 0) nums[currId - 1] = -1;
            if (currId < nums.length - 1) nums[currId + 1] = -1;
        }

        return result;

    }
}