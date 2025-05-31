class Solution {

    char[][] board;
    String word;   
    int[][] dirs = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}}; 
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        for (int row=0; row < board.length; row++)
        {
            for (int col=0; col < board[row].length; col++)
            {
                if (board[row][col] == word.charAt(0))
                {
                    if (backtrack(row, col, 0)) return true;
                }
            }
        }

        return false;

    }

    private boolean backtrack(int row, int col, int idx)
    {
        if (idx == word.length() - 1) return true;

        char nextChar = word.charAt(idx+1);

        visited[row][col] = true;
        for (int[] dir: dirs)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (0 <= newRow && newRow < board.length
             && 0 <= newCol && newCol < board[newRow].length
             && board[newRow][newCol] == nextChar
             && !visited[newRow][newCol])
             {
                if (backtrack(newRow, newCol, idx+1)) return true;
             }
        }

        visited[row][col] = false;

        return false;

    }


}