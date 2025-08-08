class Solution {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        
        // base cases
        dp[0][0] = 0;
        for (int i=1; i<word2.length() + 1; i++)
        {
            dp[i][0] = i;
        }
        for (int j=1; j<word1.length() + 1; j++)
        {
            dp[0][j] = j;
        }

        for (int i=1; i<dp.length; i++)
        {
            char c2 = word2.charAt(i-1);
            for (int j=1; j<dp[0].length; j++)
            {
                char c1 = word1.charAt(j-1);
                dp[i][j] = Math.min(
                    dp[i-1][j-1] + 1, //replace
                    Math.min(
                        dp[i][j-1] + 1, // delete
                        dp[i-1][j] + 1)); // insert
            
                if (c1 == c2)
                {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i-1][j-1]); // match
                }
            }
        }

        // for (int i=0; i<dp.length; i++)
        //     System.out.println(Arrays.toString(dp[i]));

        return dp[word2.length()][word1.length()];

    }










    // int[][] memo;
    // public int minDistance(String word1, String word2) {

    //     memo = new int[word1.length() + 1][word2.length() + 1];
    //     for (int i=0; i<word1.length(); i++)
    //     {
    //         Arrays.fill(memo[i], -1);
    //     }

    //     return dfs(0, 0, word1, word2);    
    // }

    // private int dfs(int idx1, int idx2, String word1, String word2)
    // {
    //     if (idx2 == word2.length()) return word1.length() - idx1;
    //     if (idx1 == word1.length()) return word2.length() - idx2;

    //     if (memo[idx1][idx2] != -1) return memo[idx1][idx2];

    //     char c1 = word1.charAt(idx1);
    //     char c2 = word2.charAt(idx2);

    //     int result = Integer.MAX_VALUE;
    //     if (c1 == c2)
    //     {
    //         result = Math.min(result, dfs(idx1 + 1, idx2 + 1, word1, word2)); //take
    //     } else {
    //         result = Math.min(result, 
    //                     Math.min(1 + dfs(idx1, idx2 + 1, word1, word2), // insert
    //                         Math.min(1 + dfs(idx1 + 1, idx2, word1, word2), // delete
    //                             1 + dfs(idx1 + 1, idx2 + 1, word1, word2)))); //replace
    //     }

        
    //     return memo[idx1][idx2] = result;

    // }
}