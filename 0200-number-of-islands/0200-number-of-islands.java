class Solution {
    private record Coordinate (int row, int col) {}
    LinkedList<Coordinate> queue = new LinkedList<>();

    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i=0; i< grid.length; i++)
        {
            for (int j=0; j<grid[i].length; j++)
            {
                if (grid[i][j] - '0' == 1)
                {
                    queue.offer(new Coordinate(i, j));
                    while (queue.peek() != null)
                    {
                        final Coordinate coord = queue.poll();
                        int rowC = coord.row;
                        int colC = coord.col;
                        if ((rowC < 0) || (rowC == grid.length) || (colC < 0) || (colC == grid[0].length))
                        {
                            continue;
                        }
                        if (grid[rowC][colC] - '0' == 1)
                        {
                            grid[rowC][colC] = 2;
                            queue.offer(new Coordinate(rowC - 1, colC));
                            queue.offer(new Coordinate(rowC + 1, colC));
                            queue.offer(new Coordinate(rowC, colC - 1));
                            queue.offer(new Coordinate(rowC, colC + 1));
                        }
                    }

                    result += 1;
                }
            }
        }

        return result;
    }
}