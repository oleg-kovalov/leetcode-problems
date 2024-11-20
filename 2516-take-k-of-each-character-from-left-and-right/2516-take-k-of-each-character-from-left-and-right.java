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
        int maxWindow = 0; // size of largest window that can be removed
        while (start < s.length() && end < s.length())
        {
            runningCount[s.charAt(end) - 'a']++;        

            if (count[0] - runningCount[0] >= k
                && count[1] - runningCount[1] >= k
                && count[2] - runningCount[2] >= k)
            {
                maxWindow = Math.max(maxWindow, end - start + 1);
                end++;
            } else {
                // invalid window, start over at end+1
                start = end + 1;
                end = start;
                runningCount = new int[3];
            }
        }

        return s.length() - maxWindow;
    }
}