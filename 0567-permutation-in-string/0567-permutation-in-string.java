class Solution {
    public boolean checkInclusion(String s1, String s2) { //ab  cdba
        if (s2.length() < s1.length()) return false;

        int[] freq1 = new int[26]; //[1 1 0 0]
        for (int i=0; i<s1.length(); i++)
        {
            freq1[s1.charAt(i) - 'a'] += 1;
        }

        int[] freq2 = new int[26]; // [1 1 0 0]
        for (int i=0; i<s1.length(); i++)
        {
            freq2[s2.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(freq1, freq2)) return true;

        int left = 1; // 2

        while (left + s1.length() - 1 < s2.length())
        {
            freq2[s2.charAt(left - 1) - 'a'] -= 1;
            freq2[s2.charAt(left + s1.length() - 1) - 'a'] += 1;

            if (Arrays.equals(freq1, freq2)) return true;

            left += 1;
        }

        return false;

    }
}