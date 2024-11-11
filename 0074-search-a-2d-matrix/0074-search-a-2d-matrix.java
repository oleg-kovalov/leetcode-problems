class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 1) return target == matrix[0][0];

        int[] arr = new int[matrix.length * matrix[0].length];

        for (int row=0; row < matrix.length; row++)
        {
            for (int col=0; col < matrix[0].length; col++)
            {
                arr[row * matrix.length + col] = matrix[row][col];
            }
        }

        int lo = 0;
        int hi = arr.length-1;

        while (lo < hi)
        {
            int mid = (hi + lo) / 2;

            if (target == arr[mid])
            {
                return true;
            }
            else if (target < arr[mid])
            {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return target == arr[lo];
    }
}