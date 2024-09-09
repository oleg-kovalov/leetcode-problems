class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        int maxGap = 0;

        for (int i=1; i<points.length; i++)
        {
            maxGap = Math.max(maxGap, points[i][0] - points[i-1][0]);
        }

        return maxGap;
    }
}