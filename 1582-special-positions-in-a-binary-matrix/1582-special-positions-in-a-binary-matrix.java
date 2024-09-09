class Solution {
    public int numSpecial(int[][] mat) {
        int result = 0;

        List<Integer> clearRows = new ArrayList<Integer>();
        for (int i=0; i<mat.length; i++) {
            boolean seenOne = false;
            boolean seenMore = false;
            for (int j=0; j<mat[i].length; j++) {
                if (mat[i][j] == 1)
                {
                    if (seenOne)
                    {
                        seenMore = true;
                        break;
                    }
                    seenOne = true;
                }
            }
            if (seenOne && !seenMore)
            {
                clearRows.add(i);
            }
        }

        List<Integer> clearCols = new ArrayList<Integer>();
        for (int j=0; j<mat[1].length; j++) {
            boolean seenOne = false;
            boolean seenMore = false;
            for (int i=0; i<mat.length; i++) {
                if (mat[i][j] == 1)
                {
                    if (seenOne)
                    {
                        seenMore = true;
                        break;
                    }
                    seenOne = true;
                }
            }
            if (seenOne && !seenMore)
            {
                clearCols.add(j);
            }
        }

        for (Integer row : clearRows) {
            for (Integer col : clearCols) {
                if (mat[row][col] == 1)
                {
                    result++;
                }
            }
        }

        return result;
    }
}