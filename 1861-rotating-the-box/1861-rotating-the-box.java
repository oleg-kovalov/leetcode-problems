class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        for (int row=0; row < box.length; row++)
        {
            int idx = box[0].length - 1;
            int space = -1;
            while (idx >= 0)
            {
                char curr = box[row][idx];
                if (space == -1)
                {
                    if (curr == '.')
                    {
                        space = idx;
                    }
                    idx -= 1;
                } else {
                    if (curr == '.')
                    {
                        // do nothing
                        idx -= 1;
                    } else if (curr == '*')
                    {
                        // reset space idx
                        space = -1;
                        idx -= 1;
                    } else {
                        // swap stone and space
                        box[row][idx] = '.';
                        box[row][space] = '#';
                        // start over one position above stone
                        idx = space -1;
                        space = -1;
                    }
                }
            }
        }
        
        //rotate
        char[][] rotated = new char[box[0].length][box.length];
        for (int row=0; row < rotated.length; row++)
        {
            for (int col=0; col < rotated[0].length; col++)
            {
                rotated[row][col] = box[box.length - 1 - col][row];
            }
        }

        return rotated;

  
    }
}