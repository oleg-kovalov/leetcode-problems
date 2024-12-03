class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(
            Math.abs(a[0] * a[0]) + Math.abs(a[1] * a[1]),
            Math.abs(b[0] * b[0]) + Math.abs(b[1] * b[1])));

        for (int[] point: points)
        {
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i=0; i<result.length; i++)
        {
            result[i] = minHeap.poll();
        }

        return result;

    }
}