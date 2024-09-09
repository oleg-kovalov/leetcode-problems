class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        if (length <= 8)
        {
            return length;
        } else if (length <= 16)
        {
            return 8 + 2 * (length - 8);
        } else if (length <= 24)
        {
            return 8 + 16 + 3 * (length - 16);
        } else {
            return 8 + 16 + 24 + 4 * (length -24);
        }
    }
}