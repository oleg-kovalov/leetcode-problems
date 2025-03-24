class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        int[] count = new int[26];
        for (int i=0; i<s.length(); i++)
        {
            count[s.charAt(i) - 'a'] += 1;
        }

        int oddChars = 0;
        for (int c: count)
        {
            if ((c % 2) != 0) oddChars++;
        }

        if (oddChars > k) return false;

        return true;
    }
}