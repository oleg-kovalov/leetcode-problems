class Solution {
    public boolean isAnagram(String s, String t) {
        int[] empty = new int[26];
        Arrays.fill(empty, 0);

        int[] letters = new int[26];
        Arrays.fill(letters, 0);

        char[] chars1 = s.toCharArray();
        for (char c1 : chars1) {
            letters[c1 - 'a']++;
        }

        char[] chars2 = t.toCharArray();
        for (char c2 : chars2) {
            letters[c2 - 'a']--;
        }

        return Arrays.equals(letters, empty);
    }
}