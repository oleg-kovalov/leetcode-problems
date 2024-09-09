class Solution {
    public boolean makeEqual(String[] words) {

        int[] counting = new int[26];
        
        for (String word : words) {
            for (int c=0; c<word.length(); c++)
            {
                counting[word.charAt(c) - 'a']++;
            }
        }

        for (int i : counting) {
            if (i % words.length != 0) return false;
        }
        
        return true;
    }
}