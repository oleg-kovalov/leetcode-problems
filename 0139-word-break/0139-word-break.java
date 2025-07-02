class Solution {
    Set<String> dict;
    Boolean[][] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length() + 1][s.length() + 1];


        return dfs(0, 1, s);
    }


    private boolean dfs(int start, int end, String s)
    {
        if (end == s.length() + 1)
        {
            return start == s.length(); 
        }

        if (memo[start][end] != null) return memo[start][end];


        if (dict.contains(s.substring(start, end)))
        {
            // 2 options: take match or skip it
            return memo[start][end] = 
                dfs(end, end + 1, s) // take
                || dfs(start, end + 1, s); //skip
        } else {
            return memo[start][end] = 
                dfs(start, end + 1, s); // skip
        }

    }


}