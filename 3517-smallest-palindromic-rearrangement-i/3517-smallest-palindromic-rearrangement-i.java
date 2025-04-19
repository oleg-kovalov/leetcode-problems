class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26]; 

        for (int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i) - 'a'] += 1;
        }

        int mid = -1;
        StringBuilder result = new StringBuilder();
        for (int i=0; i<freq.length; i++)
        {
            int cfreq = freq[i];
            if (cfreq % 2 != 0)
            {
                mid = i;
            }
            for (int j=0; j < cfreq/2; j++)
            {
                result.append(((char)('a' + i)));
            }
        }

        int halfLen = result.length();
        if (mid >= 0) {
            result.append((char)('a' + mid));
        }

        for (int i=halfLen - 1; i>=0; i--)
        {
            result.append(result.charAt(i));
        }

        return result.toString();
    }
}