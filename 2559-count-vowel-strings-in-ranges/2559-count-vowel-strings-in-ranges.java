class Solution {
    Set<Character> vowels = Set.of('a','e','i','o','u');
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] prefix = new int[words.length + 1];
        prefix[0] = 0;
        for (int i=1; i<words.length + 1; i++)
        {
            String word = words[i-1];
            boolean vowelStr = vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
            prefix[i] = prefix[i-1] + (vowelStr ? 1 : 0);
        }

        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++)
        {
            result[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }

        return result;
    }
}