class Solution {
    private String word;
    boolean[][] visited;
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        char start = word.charAt(0);
        for (int row=0; row<board.length; row++)
        {
            for (int col=0; col<board[row].length; col++)
            {
                if (board[row][col] - start == 0 && !found)
                {
                    // System.out.printf("start %s [%s,%s]\n", board[row][col], row, col);
                    backtrack(col,row,board, 0);
                }
            }
        }

        return found;
    }

    private void backtrack(int col, int row, char[][] board, int cIdx)
    {
        if (found)
        {
            // System.out.println("found");
            return;
        }

        if (col < 0 || col > board[0].length-1)
        {
            // System.out.println("out of range");
            return;
        }
        if (row < 0 || row > board.length-1)
        {
            // System.out.println("out of range");
            return;
        }

        if (visited[row][col])
        {
            // System.out.println("already visited");
            return;
        }

        // System.out.println(board[row][col]);

        final char ch = word.charAt(cIdx);
        if ( board[row][col] - ch != 0)
        {
            // System.out.println("backtrack");
            return;
        }

        if ( cIdx == word.length()-1)
        {
            found = true;
            // System.out.println("found last char");
            return;
        }

        visited[row][col]=true;

        // System.out.println("left");
        backtrack(col-1, row, board, cIdx+1);   //left
        // System.out.println("right");
        backtrack(col+1, row, board, cIdx + 1); //right
        // System.out.println("up");
        backtrack(col, row-1, board, cIdx+1);  //up
        // System.out.println("down");
        backtrack(col, row+1, board, cIdx+1);  //down

        visited[row][col]=false;
        // System.out.println("backtrack");

    }
}