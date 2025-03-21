class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int[][] rowsCount = new int[9][9];
        int[][] colsCount = new int[9][9];
        int[][] boxesCount = new int[9][9];


        for (int row=0; row < board.length; row++)
        {
            for (int col=0; col < board[row].length; col++)
            {
                if (board[row][col] == '.') continue;

                int value = board[row][col] - '0' - 1; //0-based
                rowsCount[row][value] += 1;
                if (rowsCount[row][value] > 1) return false;

                colsCount[col][value] += 1;
                if (colsCount[col][value] > 1) return false;

                int boxId = (row / 3) * 3 + col/3;
                boxesCount[boxId][value] += 1;
                if (boxesCount[boxId][value] > 1) return false;  
            }
        }

        return true;

    }
}