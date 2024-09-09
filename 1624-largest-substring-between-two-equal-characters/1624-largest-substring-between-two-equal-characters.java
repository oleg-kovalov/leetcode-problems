class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] charSeen = new int[26];
        int longestSubstr = -1;

        for (int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if (charSeen[ch - 'a'] == 0)
            {
                charSeen[ch - 'a'] = i+1; // 1 based index
            }
            else
            {
                int start = charSeen[ch - 'a'] - 1;
                int end = i;
                longestSubstr = Math.max(longestSubstr, end - start - 1);
            }
        }

        return longestSubstr;
    }
}