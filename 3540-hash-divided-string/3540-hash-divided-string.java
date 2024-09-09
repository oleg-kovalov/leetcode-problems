class Solution {
    public String stringHash(String s, int k) {
        char[] result = new char[s.length()/k];

        for (int i=0; i<result.length; i++)
        {
            char[] substr = s.substring(i * k, i * k + k).toCharArray();
            int sum = 0;
            for (char ch : substr)
            {
                sum += ch - 'a';
            }
            result[i] = (char)('a' + (sum % 26));
        }

        return String.valueOf(result);
    }
}