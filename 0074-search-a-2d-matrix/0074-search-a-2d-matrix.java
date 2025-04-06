class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int lo = 0;
        int hi = matrix.length;
        int targetRow = -1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] == target) return true;

            if (matrix[mid][0] < target)
            {
                targetRow = mid;
                lo = mid + 1;
            } else 
            {
                hi = mid - 1;
            }
        }

        if (targetRow == -1) return false;


        lo = 0;
        hi = matrix[0].length;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (matrix[targetRow][mid] < target)
            {
                lo = mid + 1;
            } else if (matrix[targetRow][mid] > target)
            {
                hi = mid - 1;
            } else {
                return true;
            }
        } 

        return false;

    }
}