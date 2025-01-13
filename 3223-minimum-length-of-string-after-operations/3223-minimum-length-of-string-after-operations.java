class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];

        for (int i=0; i<s.length(); i++)
        {
            count[s.charAt(i) - 'a'] += 1;
        }

        int result = 0;
        for (int c: count)
        {
            while (c >= 3)
            {
                c -= 2;
            }
            result += c;
        }

        return result;
    }
}