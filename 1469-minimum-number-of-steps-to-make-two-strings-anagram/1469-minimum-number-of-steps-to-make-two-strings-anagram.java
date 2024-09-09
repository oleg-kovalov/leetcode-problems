class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];

        for (int i=0; i<s.length(); i++)
        {
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i=0; i<t.length(); i++)
        {
            count[t.charAt(i) - 'a'] -= 1;
        }

        int result = 0;
        for (int i=0; i<count.length; i++)
        {
            // there are missing characters (negative values)
            // and extra characters (positive values)
            // we can count only one of them
            if (count[i] > 0) result += count[i];
        }

        return result;
    }
}