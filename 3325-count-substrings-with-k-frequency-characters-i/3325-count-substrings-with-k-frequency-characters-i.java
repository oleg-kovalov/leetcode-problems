class Solution {
    int result = 0;
    public int numberOfSubstrings(String s, int k) {

        rec(s, 0, k);

        return result;
    }

    private void rec (String s, int start, int k)
    {
        if (start == s.length()) return;

        int[] count = new int[26];
        boolean valid = false;
        for (int end=start; end < s.length(); end++)
        {
            if (valid)
            {
                result++;
                continue;
            }

            count[s.charAt(end) - 'a']++;
            for (int c: count)
            {
                if (c >= k) {
                    result++;
                    valid = true;
                    break;
                }
            }
        }

        rec(s, start+1, k);
    }

}