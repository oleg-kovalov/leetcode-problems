class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int[] count = new int[3]; // [a,b,c]

        for (char c : s.toCharArray())
        {
            count[c - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) return -1;

        int start = 0;
        int[] runningCount = new int[3];
        int maxWindow = 0; // size of largest window that can be removed
        for (int end = 0; end < s.length(); end++)
        {
            runningCount[s.charAt(end) - 'a']++;

            while (count[s.charAt(end) - 'a'] - runningCount[s.charAt(end) - 'a'] < k)
            {
                // invalid window, shrink from left trying to make it valid
                runningCount[s.charAt(start) - 'a']--;
                start++;
            }

            maxWindow = Math.max(maxWindow, end - start + 1);
        }

        return s.length() - maxWindow;
    }
}