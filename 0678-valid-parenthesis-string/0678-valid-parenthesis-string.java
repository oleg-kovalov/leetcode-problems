class Solution {
    public boolean checkValidString(String s) {


        boolean[][] dp = new boolean[s.length()+ 1][s.length()+1]; // balance: close +1, open -1 
        dp[s.length()][0] = true;
        for (int i=s.length()-1; i>=0; i--)
        {
            char c = s.charAt(i);
            for (int j=0; j<s.length(); j++)
            {
                if (c == ')')
                {
                    dp[i][j] = (j-1 < 0 ? false : dp[i+1][j-1]);
                } else if (c == '(')
                {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = dp[i+1][j] // empty
                        || dp[i+1][j+1] // open           
                        || (j-1 < 0 ? false : dp[i+1][j-1]); // close                    
                }
            }
        }

        // for (int i=0; i<dp.length; i++)
        //     System.out.println(Arrays.toString(dp[i]));

        return dp[0][0];
    }
}