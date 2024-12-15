class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(
            (b[0] + 1) / (b[1] + 1) - b[0] / b[1], (a[0] + 1) / (a[1] + 1) - a[0] / a[1]));

        for (int[] cls: classes)
        {
            maxHeap.offer(new double[] {cls[0], cls[1], 1.0 * (cls[0] + 1) / (cls[1] + 1) - 1.0 * cls[0] / cls[1]});
        }

        for (int i=0; i<extraStudents; i++)
        {
            double[] cls = maxHeap.poll();
            maxHeap.offer(new double[] {cls[0] + 1, cls[1] + 1, (cls[0] + 2) / (cls[1] + 2) - (cls[0] + 1) / (cls[1] + 1) });
        }

        double rates = 0.0;

        while (maxHeap.size() > 0)
        {
            double[] cls = maxHeap.poll();
            rates += cls[0] / cls[1];
        }

        return rates / classes.length;


    }
}