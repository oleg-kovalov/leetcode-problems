class Solution {
    record Point(int row, int col) {}
    HashMap<Point, Integer> cache = new HashMap<>();

    public int minFallingPathSum(int[][] matrix) {
        int minFallPath = Integer.MAX_VALUE;

        for (int col=0; col < matrix[0].length; col++)
        {
            minFallPath = Math.min(minFallPath, fall(new Point(0, col), matrix));
        }

        return minFallPath;
    }

    private int fall(Point current, int[][] matrix)
    {
        if (cache.containsKey(current))
        {
            return cache.get(current);
        }
        int currentRow = current.row;
        int currentCol = current.col;

        int currSum = matrix[currentRow][currentCol];

        if (currentRow < matrix.length-1)
        {
            int left = Math.max(0, currentCol-1);
            int right = Math.min(matrix[0].length-1, currentCol+1);
            int bottomSum = Integer.MAX_VALUE;
            for (int col=left; col <=right; col++)
            {
                bottomSum = Math.min(bottomSum, fall(new Point(currentRow+1, col), matrix));
            }

            currSum += bottomSum;
        }

        cache.put(current, currSum);

        return currSum;
    }
}