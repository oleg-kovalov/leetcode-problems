class Solution {
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int result = 0;

            for (int i=0; i<s.length(); i++)
            {
                // base case - one-letter palindromes
                dp[i][i] = true;
                result++;
            }

            for (int i=0; i<s.length()-1; i++)
            {
                // base case - two-letter palindromes
                dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
                if (dp[i][i+1]) result++;
            }

            // all other cases are expansions of palindromes with one-letter or two-letter centers
            for (int n=3; n <= s.length(); n++)
            {
                for (int i=0; i <= s.length() - n; i++)
                {
                    int start = i;
                    int end = i+n-1;
                    dp[start][end] = dp[start+1][end-1] && (s.charAt(start) == s.charAt(end));
                    if (dp[start][end]) result++;
                }
            }

            // System.out.println(result);

            return result;

        }
}
