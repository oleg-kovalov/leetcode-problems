class Solution {
    public String mergeAlternately(String word1, String word2) {
        final int length1 = word1.length();
        final int length2 = word2.length();
        final int longer = length1 > length2 ? length1 : length2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < longer; i++) {
            if (i < length1) result.append(word1.charAt(i));
            if (i < length2) result.append(word2.charAt(i));
        }

        return result.toString();
    }
}