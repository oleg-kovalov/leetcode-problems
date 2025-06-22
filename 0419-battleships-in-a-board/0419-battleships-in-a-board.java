class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        int count = 0;

        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (board[row][col] != 'X') continue;
                if (visited[row][col]) continue;

                count += 1;
                LinkedList<int[]> queue = new LinkedList<>();
                visited[row][col] = true;
                queue.offer(new int[] {row, col});

                while (queue.size() > 0)
                {
                    int[] cell = queue.poll();

                    for (int[] dir: dirs)
                    {
                        int newRow = cell[0] + dir[0];
                        int newCol = cell[1] + dir[1];

                        if (0 <= newRow && newRow < rows
                            && 0 <= newCol && newCol < cols
                            && !visited[newRow][newCol]
                            && board[newRow][newCol] == 'X')
                        {
                            visited[newRow][newCol] = true;
                            queue.offer(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }

        return count;




    }
}