class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        double maxDiagonal = Integer.MIN_VALUE;
        int maxAreaForDiagonal = Integer.MIN_VALUE;

        for (int[] dimension : dimensions) {
            double diagonal = Math.sqrt(dimension[0]*dimension[0] + dimension[1]*dimension[1]);
            if (diagonal > maxDiagonal)
            {
                maxDiagonal = diagonal;
                maxAreaForDiagonal = dimension[0] * dimension[1];
            } else if (diagonal == maxDiagonal)
            {
                maxAreaForDiagonal = Math.max(maxAreaForDiagonal,  dimension[0] * dimension[1]);
            }
        }

        return maxAreaForDiagonal;
    }
}