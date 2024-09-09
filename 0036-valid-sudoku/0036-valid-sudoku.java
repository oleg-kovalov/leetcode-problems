class Solution {
        public boolean isValidSudoku(char[][] board)
        {
            int[] seenRows = new int[board.length];
            int[] seenCols = new int[board.length];
            int[] seenBoxes = new int[board.length];


            for (int row = 0; row < board.length; row++)
            {
                for (int col = 0; col < board[row].length; col++)
                {
                    if (board[row][col] - '.' == 0) continue;

                    int bit = board[row][col] - '0' - 1; // bit position
                    int mask = 1 << bit;
                    //check row
                    if ((seenRows[row] &  mask) > 0) {
                        return false;
                    }
                    seenRows[row] |= mask;

                    //check col
                    if ((seenCols[col] & mask) > 0) {
                        return false;
                    }
                    seenCols[col] |= mask;

                    //check box
                    int boxNumber = (row / 3) * 3 + (col / 3);
                    if ((seenBoxes[boxNumber] & mask) > 0)
                    {
                        return false;
                    }
                    seenBoxes[boxNumber] |= mask;
                }
            }

            return true;
        }
}