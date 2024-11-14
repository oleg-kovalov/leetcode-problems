class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        
        for (int m=0; m < quantities.length; m++)
        {
            maxHeap.offer(new int[]{quantities[m], 1, quantities[m]});
        }

        for (int i=1; i<= n-quantities.length; i++)
        {
            int[] curr = maxHeap.poll();
            curr[1] += 1;
            curr[2] = roundUp(curr[0], curr[1]);
            maxHeap.offer(curr);
        }

        return maxHeap.peek()[2];
    }

    private int roundUp(int a, int b)
    {
        return a / b + ((a % b) > 0 ? 1 : 0); 
    }
}