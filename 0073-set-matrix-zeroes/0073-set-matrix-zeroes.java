class Solution {        
        public void setZeroes(int[][] matrix)
        {
            boolean rowOneToZero = false;
            boolean colOneToZero = false;
            
            for (int row=0; row < matrix.length; row++)
            {
                if (matrix[row][0] == 0)
                {
                    colOneToZero = true;
                }
            }
            for (int col=0; col < matrix[0].length; col++)
            {
                if (matrix[0][col] == 0)
                {
                    rowOneToZero = true;
                }
            }
            
            for (int row = 1; row < matrix.length; row++)
            {
                for (int col = 1; col < matrix[row].length; col++)
                {
                    if (matrix[row][col] == 0)
                    {
                        matrix[0][col] = 0;
                        matrix[row][0] = 0;
                    }
                }
            }

            // inner row & col
            for (int row = 1; row < matrix.length; row++)
            {
                for (int col = 1; col < matrix[row].length; col++)
                {
                    if (matrix[0][col] == 0 || matrix[row][0] == 0)
                    {
                        matrix[row][col] = 0;
                    }
                }
            }

            if (rowOneToZero)
            {
                for (int col=0; col < matrix[0].length; col++)
                {
                    matrix[0][col] = 0;
                }
            }
            if (colOneToZero)
            {
                for (int row=0; row < matrix.length; row++)
                {
                    matrix[row][0] = 0;
                }
            }
        }
        
}