class Solution {
    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        zeros[0] = (s.charAt(0) == '0' ? 1 : 0);
        for (int i=1; i<s.length(); i++)
        {
            zeros[i] = zeros[i-1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int[] ones = new int[s.length()];
        ones[s.length() - 1] = (s.charAt(s.length() - 1) == '1' ? 1 : 0);
        for (int i=s.length() - 2; i >=0; i--)
        {
            ones[i] = ones[i+1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int maxScore = -1;
        for (int i=1; i<s.length(); i++)
        {
            maxScore = Math.max(maxScore, zeros[i-1] + ones[i]);
        }

        return maxScore;

    }
}