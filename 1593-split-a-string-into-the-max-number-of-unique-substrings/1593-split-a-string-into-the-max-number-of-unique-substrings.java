class Solution {
    
    HashSet<String> seen = new HashSet<>();
    int result = 0;
    public int maxUniqueSplit(String s) {
        if (s.length() == 1) return 1;

        backtrack(s, 0, 0);
        return result;

    }

    private void backtrack(String s, int start, int count)
    {
        if (count + s.length() - start  <= result)
        {
            return;
        }

        if (start == s.length()) {
            result = Math.max(result, count);
            return;
        }

        for (int end = start+1; end < s.length()+1; end++)
        {
            String substr = s.substring(start, end);
            if (seen.contains(substr)) continue;

            seen.add(substr);
            backtrack(s, end, count + 1);

            seen.remove(substr);
        }

    }
}