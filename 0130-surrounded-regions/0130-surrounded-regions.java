class Solution {

    int rows;
    int cols;
    int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if ( (row == 0 || row == rows-1 || col == 0 || col == cols-1)
                    && board[row][col] == 'O')
                {
                    board[row][col] = 'E';
                    dfs(row, col, board);
                }
            }
        }

        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (board[row][col] == 'O') board[row][col] = 'X';
                if (board[row][col] == 'E') board[row][col] = 'O';
            }
        }
    }

    private void dfs(int row, int col, char[][] board)
    {

        for (int[] dir: dirs)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (0 <= newRow && newRow < rows
                && 0<= newCol && newCol < cols
                && board[newRow][newCol] == 'O')
            {
                board[newRow][newCol] = 'E';
                dfs(newRow, newCol, board);   
            }
        }

    }


}