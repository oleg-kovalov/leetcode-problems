class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lo = 0;
        int hi = rows * cols - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (target < matrix[row][col])
            {
                hi = mid - 1;
            } else if (target > matrix[row][col])
            {
                lo = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}