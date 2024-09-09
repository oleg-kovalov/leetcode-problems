class Solution {
    public int minimumPushes(String word) {
        int[] freqs = new int[26];

        for (int i=0; i<word.length(); i++){
            freqs[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freqs); //ASC

        int result = 0;
        for (int i=freqs.length-1; i>=0; i--)
        {
            if (freqs[i] == 0) {
                return result;
            }

            result += (((freqs.length-1 - i) / 8) + 1) * freqs[i];
        }

        return result;
    }
}