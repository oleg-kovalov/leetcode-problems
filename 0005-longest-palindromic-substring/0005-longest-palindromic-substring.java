class Solution {
    public String longestPalindrome(String s) {
        int longestStart = 0;
        int longestEnd = 0;

        for (int i=0; i < s.length(); i++)
        {
            char current = s.charAt(i);

            if (0 <= i-1 && i+1 < s.length()
                && s.charAt(i-1) == s.charAt(i+1) )
            {
                // middle of palindrom type ABA
                int start = i-1;
                int end = i+1;

                while (0 <= start-1 && end+1 < s.length() && s.charAt(start-1) == s.charAt(end+1))
                {
                    start = start - 1;
                    end = end + 1;
                }
                if (end+1 - start > longestEnd - longestStart)
                {
                    longestStart = start;
                    longestEnd = end;
                }
            }

            if (i+1 < s.length() && current == s.charAt(i+1))
            {
                // middle of palindrom type AA
                int start = i;
                int end = i+1;

                while (0 <= start-1 && end+1 < s.length() && s.charAt(start-1) == s.charAt(end+1))
                {
                    start = start - 1;
                    end = end + 1;
                }
                if (end+1 - start > longestEnd - longestStart)
                {
                    longestStart = start;
                    longestEnd = end;
                }
            }

        }

        return s.substring(longestStart, longestEnd+1);
    }
}