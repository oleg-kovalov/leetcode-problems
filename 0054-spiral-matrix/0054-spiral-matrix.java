class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int cellsToVisit = matrix.length * matrix[0].length;

        int[][] directions = new int[][] {
            {0, 1}, //right
            {1, 0}, //down
            {0,-1}, //left
            {-1, 0} //up
        };

        int[] boundaries = new int[]{
            matrix[0].length-1, //right
            matrix.length-1, //bottom
            0, //left
            1 //top
        };

        int direction = 0;
        int row = 0;
        int col = -1;

        while (cellsToVisit > 0)
        {
            int boundary = boundaries[direction];
            if (direction == 0 && col == boundary)
            {
                // right
                boundaries[direction] -= 1;
                direction = (direction + 1) % 4;
            }
            else if (direction == 1 && row == boundary)
            {
                //down
                boundaries[direction] -= 1;
                direction = (direction + 1) % 4;
            }
            else if (direction == 2 && col == boundary) {
                //left
                boundaries[direction] += 1;
                direction = (direction + 1) % 4;
            }
            else if (direction == 3 && row == boundary)
            {
                //up
                boundaries[direction] += 1;
                direction = (direction + 1) % 4;
            }

            row += directions[direction][0];
            col += directions[direction][1];
            result.add(matrix[row][col]);
            // System.out.println(matrix[row][col]);
            cellsToVisit--;
        }

        return result;
    }
}