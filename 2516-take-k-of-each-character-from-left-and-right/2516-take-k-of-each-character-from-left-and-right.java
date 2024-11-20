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
        int end = 0;
        int[] runningCount = new int[3];
        runningCount[s.charAt(start) - 'a']++;
        int maxWindow = 0; // size of largest window that can be removed
        while (start < s.length() && end < s.length())
        {

            if (count[0] - runningCount[0] >= k
                && count[1] - runningCount[1] >= k
                && count[2] - runningCount[2] >= k)
            {
                maxWindow = Math.max(maxWindow, end - start + 1);
                end++;
                if (end == s.length()) break;
                runningCount[s.charAt(end) - 'a']++;
            } else {
                // invalid window, shrink from left trying to make it valid
                runningCount[s.charAt(start) - 'a']--;
                start++;
                if (start > end)
                {
                    //invalid, start over at end+1
                    start = end + 1;
                    if (start == s.length()) break;
                    end = start;
                    runningCount = new int[3];
                    runningCount[s.charAt(start) - 'a']++;
                }
            }
        }

        return s.length() - maxWindow;
    }
}