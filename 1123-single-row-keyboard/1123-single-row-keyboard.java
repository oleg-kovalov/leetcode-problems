class Solution {
    public int calculateTime(String keyboard, String word) {
        int currKey = 0;
        int time = 0;

        Map<Character, Integer> indices = new HashMap<>();
        for (int i=0; i<keyboard.length(); i++)
        {
            indices.put(keyboard.charAt(i),i);
        }

        for (int i=0; i<word.length();i++)
        {
            int nextKey = indices.get(word.charAt(i));
            time += Math.abs(nextKey - currKey);
            currKey = nextKey;
        }

        return time;
    }
}