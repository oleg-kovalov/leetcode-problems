class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int center=0; center < n; center++)
        {
            // palindromes with odd length, with center as single char
            int left = center;
            int right = center;
            while (0 <= left && right < n && s.charAt(left) == s.charAt(right))
            {
                count += 1;
                left -= 1;
                right += 1;
            }

            if (center < n - 1 && s.charAt(center) == s.charAt(center + 1))
            {
                // palindromes with even length, with center has 2 chars
                left = center;
                right = center + 1;
                while (0 <= left && right < n && s.charAt(left) == s.charAt(right))
                {
                    count += 1;
                    left -= 1;
                    right += 1;
                }
            }
        }

        return count;
    }
}