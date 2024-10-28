class Solution {
    Set<String> dict = new HashSet<>();
    Map<Integer, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict)
        {
            dict.add(word);
        }

        return backtrack(s, 0);
    }

    private boolean backtrack(String s, int start)
    {
        if (memo.containsKey(start)) return memo.get(start);
        
        if (start > s.length()) return false;
        if (start == s.length()) return true;

        for (int end=s.length(); end >= start+1; end--)
        {
            if (dict.contains(s.substring(start, end)))
            {
                if (backtrack(s, end)) {
                    memo.put(start, true);
                    return true;
                }
            }
        }

        memo.put(start, false);
        return false;
    }

}