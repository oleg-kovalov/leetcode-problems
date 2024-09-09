class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char sc : s.toCharArray()) {
            result ^= sc;
        }

        for (char tc : t.toCharArray()) {
            result ^= tc;
        }

        return result;
    }
}