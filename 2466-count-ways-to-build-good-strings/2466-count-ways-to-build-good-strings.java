class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int [] dp = new int[high + 1];
        dp[0] = 1;

        for (int i=1; i<high + 1; i++)
        {
            dp[i] = ((i < zero ? 0 : dp[i - zero]) + (i < one ? 0 : dp[i - one])) % mod;
        }

        int result = 0;
        for (int i=low; i< high + 1; i++)
        {
            result += dp[i];
            result %= mod;
        }

        return result;
    }
    
}