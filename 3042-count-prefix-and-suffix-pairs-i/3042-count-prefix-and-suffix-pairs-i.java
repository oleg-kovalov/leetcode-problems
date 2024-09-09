class Solution {
    public int countPrefixSuffixPairs(String[] words) {

        int result = 0;
        for (int i=0; i<words.length; i++)
        {
            String word = words[i];
            for (int j=i+1; j< words.length; j++)
            {
                if (words[j].startsWith(word) && words[j].endsWith(word))
                    result++;
            }
        }
        return result;
    }
}