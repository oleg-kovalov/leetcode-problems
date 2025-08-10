class Solution {
    int ALICE = 0;
    int BOB = 1;
    int[][][] memo;
    public int stoneGameII(int[] piles) {
        memo = new int[piles.length][2 * piles.length][2];


        return dfs(0, ALICE, 1, piles);

    }

    private int dfs(int idx, int turn, int m, int[] piles) // always return score of Alice
    {
        if (idx >= piles.length ) return 0;

        if (memo[idx][m][turn] != 0) return memo[idx][m][turn];

        int result = turn == ALICE ? 0 : Integer.MAX_VALUE; 
        int score = 0;
        for (int x=1; x< 2*m + 1; x++)
        {
            if (idx + x - 1 == piles.length) break;

            score += piles[idx + x - 1];
                            
            if (turn == ALICE)
            {
                // when Alice's turn, maximize score
                result = Math.max(result, score + dfs(idx + x, (turn + 1) % 2, Math.max(m, x), piles));
            } else {
                // when Bob's turn, minimize score of Alice
                result = Math.min(result, dfs(idx + x, (turn + 1) % 2, Math.max(m, x), piles));
            }
        }

        return memo[idx][m][turn] = result;
    }
}