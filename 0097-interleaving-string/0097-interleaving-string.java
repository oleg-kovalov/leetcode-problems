class Solution {

    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        
        memo = new int[s1.length() + 1][s2.length() + 1]; // 0 - not set, 1 - true, 2 - false

        return backtrack(0, 0, s1, s2, 0, s3);

    }

    private boolean backtrack(int idx1, int idx2, String s1, String s2, int idx3, String s3)
    {
        if (idx1 == s1.length() && idx2 == s2.length() && idx3 == s3.length()) return true;
        if (idx3 == s3.length()) return false;

        if (memo[idx1][idx2] != 0) return memo[idx1][idx2]  == 1 ? true : false; 

        char c3 = s3.charAt(idx3);

        boolean result = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == c3)
        {
            result |= backtrack(idx1 + 1, idx2, s1, s2, idx3 + 1, s3);
        }
        if (idx2 < s2.length() && s2.charAt(idx2) == c3)
        {
            result |= backtrack(idx1, idx2 + 1, s1, s2, idx3 + 1, s3);
        }

        memo[idx1][idx2] = (result ? 1 : 2);

        return result;

    }
}