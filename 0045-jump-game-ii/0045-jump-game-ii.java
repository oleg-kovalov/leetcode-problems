class Solution {
    public int jump(int[] nums) {

        // cost, index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        minHeap.offer(new int[] {0,0});
        
        int[] cache = new int[nums.length];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        while (minHeap.size() > 0)
        {
            int[] pos = minHeap.poll();
            int cost = pos[0], idx = pos[1];
            int jump = nums[idx];

            if (idx == nums.length - 1) return cost;

            for (int i=idx + 1; i < idx + jump + 1; i++)
            {
                if (i == nums.length) break;

                if (cache[i] <= cost + 1) continue;

                minHeap.offer(new int[] {cost + 1, i});
                cache[i] = cost + 1;
            }
        }


        return -1;
    
    }
}