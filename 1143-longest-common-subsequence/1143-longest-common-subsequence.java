class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i=0; i<text1.length(); i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return rec(0, 0, text1, text2);

    }


    private int rec(int idx1, int idx2, String text1, String text2)
    {
        if (idx1 == text1.length()) return 0;
        if (idx2 == text2.length()) return 0;

        if (memo[idx1][idx2] != -1) return memo[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2))
        {
            return memo[idx1][idx2] = 1 + rec(idx1 + 1, idx2 + 1, text1, text2);
        } else {
            return memo[idx1][idx2] = Math.max(
                rec(idx1 + 1, idx2, text1, text2),
                rec(idx1, idx2 + 1, text1, text2)
            );
        }
    }

}