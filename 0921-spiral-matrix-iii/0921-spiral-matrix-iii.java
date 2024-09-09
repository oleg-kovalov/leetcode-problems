class Solution {
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart)
        {
            int[][] result = new int[rows * cols][2];
            int index = 0;

            // directions: 0 - east, 1 - south, 2 - west, 3 - north
            int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int direction = 0;

            //put first
            result[index][0] = rStart;
            result[index][1] = cStart;
            index++;

            //in spiral traversal we increase the side of spiral by one after 2 turns:
            // right by 1
            // down by 1
            // left by 2
            // up by 2
            // right by 3
            int steps = 1;
            int coordR = rStart;
            int coordC = cStart;
            while (index < rows * cols)
            {
                for (int onetwo = 1; onetwo <=2; onetwo++)
                {
                    for (int step = 0; step < steps; step++)
                    {
                        coordR += directions[direction][0];
                        coordC += directions[direction][1];
                        if (0 <= coordR && coordR < rows && 0 <= coordC && coordC < cols)
                        {
                            result[index][0] = coordR;
                            result[index][1] = coordC;
                            index++;
                        }
                    }
                    direction = (direction + 1) % 4;
                }
                steps += 1;
            }

            return result;

        }
    
}