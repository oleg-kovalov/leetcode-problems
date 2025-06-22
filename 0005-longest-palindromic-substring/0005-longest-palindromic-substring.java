class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resultStart = 0;
        int resultEnd = 0;

        boolean[][] dp = new boolean[n][n]; // boolean true if it's palindrone at start, end indices 
        int len = 1;
        for (int start=0; start + len-1 < n; start++)
        {
            dp[start][start + len-1] = true; // size 1 is always a palindrome
        }

        len = 2;
        for (int start=0; start + len-1 < n; start++)
        {
            dp[start][start + len-1] = (s.charAt(start) == s.charAt(start + len-1)); // size 2
            if (dp[start][start + len-1])
            {
                resultStart = start;
                resultEnd = start + len - 1;
            }
        }

        for (len=3; len < n + 1; len++)
        {
            for (int start=0; start + len-1<n; start++)
            {
                dp[start][start + len-1] = dp[start + 1][start+len-1 - 1] && (s.charAt(start) == s.charAt(start + len-1));          
                if (dp[start][start + len-1])
                {
                    resultStart = start;
                    resultEnd = start + len - 1;
                }
            }
        }

        return s.substring(resultStart, resultEnd + 1);






    }
}