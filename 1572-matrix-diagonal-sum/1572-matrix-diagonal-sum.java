class Solution {
    public int diagonalSum(int[][] mat) {
        int size = mat[0].length;
        int sum = 0;
        int j = 0;
        for (int i=0; i < size; i++)
        {
            sum += mat[i][j];
            if (j != size - 1 - j)
            {
                sum += mat[i][size - 1 - j];
            }

            j++;
        }

        return sum;
    }
}