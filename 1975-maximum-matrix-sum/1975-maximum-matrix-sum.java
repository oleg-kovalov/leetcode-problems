class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        boolean hasZero = false;
        int smallestAbs = Integer.MAX_VALUE;
        int negativeCount = 0;
        long totalSum = 0L;

        for (int row=0; row < matrix.length; row++)
        {
            for (int col=0; col < matrix[0].length; col++)
            {
                int curr = matrix[row][col];
                if (curr == 0) {
                    hasZero = true;
                } else if (curr > 0) {
                    totalSum += curr;
                } else {
                    smallestAbs = Math.min(smallestAbs, Math.abs(curr));
                    negativeCount += 1;
                    totalSum += Math.abs(curr);
                }
            }
        }

        if (hasZero) {
            // each negative can change sign around zero
            return totalSum;
        }
        if (negativeCount % 2 == 0)
        {
            // even number of negatives, they all can change signs around each others
            return totalSum; 
        }
        else {
            // in case of odd number of negatives, one negative remains
            return totalSum - 2 * smallestAbs;
        }
    }
}