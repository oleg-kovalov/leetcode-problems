class Solution {
    
    HashSet<String> seen = new HashSet<>();
    public int maxUniqueSplit(String s) {
        if (s.length() == 1) return 1;

        return backtrack(s, 0, 0);

    }

    private int backtrack(String s, int start, int count)
    {
        if (start == s.length()) return count;

        int result = -1;

        for (int end = start+1; end < s.length()+1; end++)
        {
            String substr = s.substring(start, end);
            if (seen.contains(substr)) continue;

            seen.add(substr);
            result = Math.max(result, backtrack(s, end, count + 1));

            seen.remove(substr);
        }

        return result;
    }
}