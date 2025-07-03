class Solution {
    public boolean wordBreak(String s, List<String> wordDict) { // catsandog
    //                                                                ^
        
        // Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1]; // t f f t


        dp[0] = true;
        for (int start=0; start < s.length(); start++)
        {
            int i = start + 1;
            dp[i] = false;
            for (String word: wordDict) // cat
            {
                dp[i] |= (start - word.length() + 1 >= 0 
                    && s.substring(start - word.length() + 1, start + 1).equals(word) 
                    && dp[start - word.length() + 1]);
                if (dp[i]) break;
            }  

        }
        System.out.println(Arrays.toString(dp));

        return dp[s.length()];


    }
}