class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
    
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int len=1; len < s3.length() + 1; len++)
        {
            char c3 = s3.charAt(len - 1);
            for (int i=0; i<len + 1; i++)
            {
                int j = len - i;
                if (i >= dp.length || j >= dp[0].length) continue;

                dp[i][j] = false;
                if (i > 0)
                {
                    dp[i][j] |= 
                        (c3 == s1.charAt(i-1) && dp[i-1][j]); // try s1
                }
                if (j > 0)
                {
                    dp[i][j] |= 
                        (c3 == s2.charAt(j-1) && dp[i][j-1]); // try s2
                }
            }
        }

        // for (int i=0; i<dp.length; i++)
        //     System.out.println(Arrays.toString(dp[i]));

        return dp[s1.length()][s2.length()];

    }













    // int[][] memo;
    // public boolean isInterleave(String s1, String s2, String s3) {
        
    //     memo = new int[s1.length() + 1][s2.length() + 1]; // 0 - not set, 1 - true, 2 - false

    //     return backtrack(0, 0, s1, s2, 0, s3);

    // }

    // private boolean backtrack(int idx1, int idx2, String s1, String s2, int idx3, String s3)
    // {
    //     if (idx1 == s1.length() && idx2 == s2.length() && idx3 == s3.length()) return true;
    //     if (idx3 == s3.length()) return false;

    //     if (memo[idx1][idx2] != 0) return memo[idx1][idx2]  == 1 ? true : false; 

    //     char c3 = s3.charAt(idx3);

    //     boolean result = false;
    //     if (idx1 < s1.length() && s1.charAt(idx1) == c3)
    //     {
    //         result |= backtrack(idx1 + 1, idx2, s1, s2, idx3 + 1, s3);
    //     }
    //     if (idx2 < s2.length() && s2.charAt(idx2) == c3)
    //     {
    //         result |= backtrack(idx1, idx2 + 1, s1, s2, idx3 + 1, s3);
    //     }

    //     memo[idx1][idx2] = (result ? 1 : 2);

    //     return result;

    // }
}