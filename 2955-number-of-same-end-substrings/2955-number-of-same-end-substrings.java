class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {

        int[][] count = new int[s.length() + 1][26];
        count[0] = new int[26];

        for (int i=0; i<s.length(); i++)
        {
            count[i + 1] = Arrays.copyOf(count[i], 26);
            count[i + 1][s.charAt(i) - 'a']++;
        }

        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++)
        {
            int[] startMinusOne = count[queries[i][0]];
            int[] end = count[queries[i][1] + 1];
            
            int subsum = 0;
            for (int c=0; c<26; c++)
            {
                int subc = end[c] - startMinusOne[c];
                while (subc > 0)
                {
                    subsum += subc;
                    subc--;
                }
            }
            result[i] = subsum;
        }

        return result;
    }
}