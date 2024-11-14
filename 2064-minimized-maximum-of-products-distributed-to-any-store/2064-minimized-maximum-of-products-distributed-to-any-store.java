class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> roundUp(b[0], b[1]) - roundUp(a[0], a[1]));
        
        for (int m=0; m < quantities.length; m++)
        {
            maxHeap.offer(new int[]{quantities[m], 1});
        }

        for (int i=1; i<= n-quantities.length; i++)
        {
            int[] curr = maxHeap.poll();
            curr[1] += 1;
            maxHeap.offer(curr);
        }

        // int max = 0;
        // while (maxHeap.size() > 0)
        // {
        //     int[] curr = maxHeap.poll();
        //     max = Math.max(max, roundUp(curr[0], curr[1]));
        // }

        // return max;

        return roundUp(maxHeap.peek()[0], maxHeap.peek()[1]);
    }

    private int roundUp(int a, int b)
    {
        return a / b + ((a % b) > 0 ? 1 : 0); 
    }
}