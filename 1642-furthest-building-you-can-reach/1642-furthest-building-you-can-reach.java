class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        
        int result = 0;
        int remBricks = bricks;
        int remLadders = ladders;
        
        for (int i=1; i<heights.length; i++)
        {
            int curr = heights[i] - heights[i-1];
            if (curr <= 0) {
                result += 1;
                continue;
            }
            remBricks -= curr;
            maxHeap.offer(curr);
            if (remBricks >= 0) 
            {
                result += 1;
            } else {
                if (remLadders > 0)
                {
                    int largest = maxHeap.poll();
                    remBricks += largest;
                    remLadders -= 1;
                    result += 1;
                } else {
                    return result;
                }
            }
        }

        return result;
    }
}