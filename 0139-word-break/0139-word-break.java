class Solution {

    HashSet<Integer> cache = new HashSet<>(); 
    public boolean wordBreak(String s, List<String> wordDict) {

        return rec(0, s, wordDict);

    }

    private boolean rec(int idx, String s, List<String> wordDict) 
    {
        if (cache.contains(idx)) return false;
        
        if (idx == s.length()) return true;
        // if (idx > s.length()) return false;

        for (String chunk: wordDict)
        {
            if (idx + chunk.length() -1 < s.length() && s.substring(idx, idx + chunk.length()).equals(chunk))
            {
                if (rec(idx + chunk.length(), s, wordDict)) return true;
            }
        }

        cache.add(idx);

        return false;
    }
}