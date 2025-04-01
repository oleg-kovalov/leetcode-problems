class Solution {
    public int lengthOfLongestSubstring(String s) {   //tmmzuxt
                                                      //  ^
                                                       //  ^
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        Set<Character> seen = new HashSet<>();
        seen.add(s.charAt(0));
        int left = 0;
        int right = left + 1;
        int result = 1;
        while (right < s.length())
        {
            while (right < s.length() && !seen.contains(s.charAt(right)))
            {
                seen.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right - left);
            if (right == s.length()) return result;

            while (s.charAt(left) != s.charAt(right))
            {
                seen.remove(s.charAt(left));
                left++;
            }
            left++;
            right++;

        }

        return result;
        
    }
}