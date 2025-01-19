class Solution {
    public int countPrefixSuffixPairs(String[] words) {

        int result = 0;
        for (int i=0; i<words.length - 1; i++)
        {
            for (int j=i+1; j<words.length; j++)
            {
                String first = words[i];
                String second = words[j];
                if (first.length() > second.length()) continue;
                if ( ! second.substring(0, first.length()).equals(first)) continue;
                if (! second.substring(second.length() - first.length(), second.length()).equals(first)) continue;

                result += 1;
            }
        }

        return result;
    }
}