class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()];

        int prevLPS = 0;
        int i = 1;

        // AAA


        while (i < lps.length)
        {
            if (needle.charAt(i) == needle.charAt(prevLPS))
            {
                lps[i] = prevLPS + 1;
                prevLPS += 1;
                i += 1; 
            } else if (prevLPS == 0)
            {
                lps[i] = 0;
                i += 1;
            } else {
                prevLPS = lps[prevLPS - 1];    
            }
        }

        int h = 0;
        int n = 0;

        while (h < haystack.length())
        {
            if (haystack.charAt(h) == needle.charAt(n))
            {
                h += 1;
                n += 1;
                if (n == needle.length()) return h - needle.length();
            } else
            {
                if (n == 0)
                {
                    h += 1;
                } else {
                    n = lps[n - 1];
                }
            }
        }

        return -1;


    }
}