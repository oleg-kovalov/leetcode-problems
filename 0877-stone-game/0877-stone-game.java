class Solution {
    int ALICE=0, BOB=1;
    int[][][] memo;
    public boolean stoneGame(int[] piles) {
        memo = new int[piles.length][piles.length][2];

        int total = 0;
        for (int pile: piles)
        {
            total += pile;
        }

        return dfs(0, piles.length-1, ALICE, piles) > (int)(total / 2);
        
    }

    private int dfs(int i, int j, int turn, int[] piles)
    {
        if (i > j) return 0; 
        // System.out.println(turn == ALICE ? "ALICE" : "BOB");

        if (memo[i][j][turn] != 0) return memo[i][j][turn];

        if (turn == ALICE)
        {
            // when it's Alice's turn, maximize own score
            return memo[i][j][turn] = 
                Math.max(
                    piles[i] + dfs(i + 1, j, (turn + 1) % 2, piles), // take first
                    piles[j] + dfs(i, j - 1, (turn + 1) % 2, piles)); // take last
        } else {
            // when it's Bob's turn, minimize Alices score
            return memo[i][j][turn] = 
                Math.min(
                    dfs(i + 1, j, (turn + 1) % 2, piles), // take first
                    dfs(i, j - 1, (turn + 1) % 2, piles)); // take last
        }

        
    }
}