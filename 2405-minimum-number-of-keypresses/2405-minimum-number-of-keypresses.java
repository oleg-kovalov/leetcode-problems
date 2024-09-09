class Solution {
    public int minimumKeypresses(String s) {
        int[] freq = new int[26];

        for (int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;
        for (int i=freq.length-1; i>=0; i--)
        {
            if (i >= 26-9) 
            {
                result += freq[i];
            } else if ( i >= 26-18)
            {
                result += freq[i] * 2;
            } else {
                result += freq[i] * 3;
            }
        }

        return result;
    }
}