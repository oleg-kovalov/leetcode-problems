class Solution {
    public String longestPalindrome(String s) {

        String result = "";

        for (int i=0; i<s.length(); i++)
        {
            // palindrome of odd length
            int l=i;
            int r=i;

            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if (r - l + 1 > result.length())
                {
                    result = s.substring(l, r+1);
                }
                l -= 1;
                r += 1;
            }

            // palindrome of even length
            l=i;
            r=i+1;

            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if (r - l + 1 > result.length())
                {
                    result = s.substring(l, r+1);
                }
                l -= 1;
                r += 1;
            }
        }

        return result;
    }
}