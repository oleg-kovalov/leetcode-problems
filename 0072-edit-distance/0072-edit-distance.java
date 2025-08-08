class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {

        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i=0; i<word1.length(); i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, word1, word2);    
    }

    private int dfs(int idx1, int idx2, String word1, String word2)
    {
        if (idx2 == word2.length()) return word1.length() - idx1;
        if (idx1 == word1.length()) return word2.length() - idx2;

        if (memo[idx1][idx2] != -1) return memo[idx1][idx2];

        char c1 = word1.charAt(idx1);
        char c2 = word2.charAt(idx2);

        int result = Integer.MAX_VALUE;
        if (c1 == c2)
        {
            result = Math.min(result, dfs(idx1 + 1, idx2 + 1, word1, word2)); //take
        } else {
            result = Math.min(result, 
                        Math.min(1 + dfs(idx1, idx2 + 1, word1, word2), // insert
                            Math.min(1 + dfs(idx1 + 1, idx2, word1, word2), // delete
                                1 + dfs(idx1 + 1, idx2 + 1, word1, word2)))); //replace
        }

        
        return memo[idx1][idx2] = result;

    }
}