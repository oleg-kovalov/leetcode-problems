class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int i=0; i<word1.length(); i++)
        {
            Arrays.fill(memo[i], -1);
        }
        
        return dfs(0, 0, word1, word2);    
    }


    private int dfs(int i1, int i2, String word1, String word2)
    {
        if (i1 == word1.length()) return word2.length() - i2; // insert all missing
        if (i2 == word2.length()) return word1.length() - i1; // delete all extra

        if (memo[i1][i2] != -1) return memo[i1][i2];

        if (word1.charAt(i1) == word2.charAt(i2))
        {
            return memo[i1][i2] 
                = dfs(i1 + 1, i2 + 1, word1, word2);
        } else {
            return memo[i1][i2] = 
                Math.min( 1 + dfs(i1, i2 + 1, word1, word2), // insert
                    Math.min(
                             1 + dfs(i1 + 1, i2 + 1, word1, word2), // replace
                             1 + dfs(i1 + 1, i2, word1, word2) // delete
                ));
        }

    }
}