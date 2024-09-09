class Solution {
    public int minMoves(int[][] rooks) {
        int moves = 0;

        //sorting by rows
        Arrays.sort(rooks, Comparator.comparing(arr -> arr[0]));
        for (int i=0; i<rooks.length; i++)
        {
            if (rooks[i][0] != i)
            {
                moves += Math.abs(i - rooks[i][0]);
                rooks[i][0] = i;
            }
        }

        //sort by cols
        Arrays.sort(rooks, Comparator.comparing(arr -> arr[1]));
        for (int i=0; i<rooks.length; i++)
        {
            if (rooks[i][1] != i)
            {
                moves += Math.abs(i - rooks[i][1]);
                rooks[i][1] = i;
            }
        }

        return moves;
    }
}