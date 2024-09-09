class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() == 1) return word1.equals(word2);

        int[] freq1 = new int[26];
        int charBit1 = 0;
        for (int i=0; i<word1.length(); i++)
        {
            charBit1 = charBit1 | (1 << (word1.charAt(i) - 'a'));
            freq1[word1.charAt(i) - 'a']++;
        }

        int[] freq2 = new int[26];
        int charBit2 = 0;
        for (int i=0; i<word2.length(); i++)
        {
            charBit2 = charBit2 | (1 << (word2.charAt(i) - 'a'));
            freq2[word2.charAt(i) - 'a']++;
        }

        if (charBit1 != charBit2) return false; //ensure word1 and word2 consist of same characters

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);

    }
}