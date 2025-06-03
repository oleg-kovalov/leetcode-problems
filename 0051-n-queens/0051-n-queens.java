class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row=0; row<n; row++)
        {
            Arrays.fill(board[row], '.');
        }

        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>() );

        return result;
    }

    private void backtrack(char[][] board, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antidiags)
    {
        if (row == board.length && cols.size() == board[0].length)
        {
            result.add(boardToResult(board));
            return;
        }

        for (int col=0; col<board[0].length; col++)
        {
            if (cols.contains(col)) continue;

            int diag = row - col;
            if (diags.contains(diag)) continue; 
            
            int antidiag = row + col;
            if (antidiags.contains(antidiag)) continue;

            board[row][col] = 'Q';
            cols.add(col);
            diags.add(diag);
            antidiags.add(antidiag);

            backtrack(board, row + 1, cols, diags, antidiags);

            board[row][col] = '.';
            cols.remove(col);
            diags.remove(diag);
            antidiags.remove(antidiag);
        }


    }

    private List<String> boardToResult(char[][] board)
    {
        List<String> result = new ArrayList<>();
        for (int row=0; row<board.length; row++)
        {
            StringBuilder rowB = new StringBuilder();
            for (int col=0; col < board[0].length; col++)
            {
                rowB.append(board[row][col]);
            }
            result.add(rowB.toString());
        }

        // System.out.println(result);
        return result;
    }
}