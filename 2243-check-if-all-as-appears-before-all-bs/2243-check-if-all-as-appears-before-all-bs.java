class Solution {
    public boolean checkString(String s) {
        int idxA = 0, idxB = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' == 0) idxA = i;  else idxB = i;

            if (idxB < idxA) return false;
        }

        return true;
    }
}