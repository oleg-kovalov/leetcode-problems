class Solution {
    public int vowelStrings(String[] words, int left, int right) {

        Set<Character> vowelChars = Set.of('a', 'e', 'i', 'o', 'u');
        int result = 0;

        for (int i=left; i<=right; i++)
        {
            if (vowelChars.contains(words[i].charAt(0))
                    && vowelChars.contains(words[i].charAt(words[i].length()-1)))
            {
                result = result + 1;
            }
        }

        return result;
    }
}