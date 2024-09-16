class Solution {
    public int findTheLongestSubstring(String s) {
        int[] charMap = new int[26];
        charMap['a' - 'a'] = 1;
        charMap['e' - 'a'] = 2;
        charMap['i' - 'a'] = 4;
        charMap['o' - 'a'] = 8;
        charMap['u' - 'a'] = 16;

        int longestSubstring = 0;
        int prefixXOR = 0;
        int[] xorStateIndices = new int[32];
        Arrays.fill(xorStateIndices, -1);

        for (int i=0; i<s.length(); i++)
        {
            prefixXOR ^= charMap[s.charAt(i) - 'a'];
            if (xorStateIndices[prefixXOR] == -1 && prefixXOR != 0)
            {
                xorStateIndices[prefixXOR] = i; // store first occurrence of particular xor state
            }
            longestSubstring = Math.max(longestSubstring, i - xorStateIndices[prefixXOR]);
        }

        return longestSubstring;
    }
}