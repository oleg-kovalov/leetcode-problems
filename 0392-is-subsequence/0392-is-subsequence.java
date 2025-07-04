class Solution {
    public boolean isSubsequence(String s, String t) {

        int ti = 0;
        int si = 0;
        while (si < s.length() && ti < t.length())
        {
            while (si < s.length() && ti < t.length() && t.charAt(ti) != s.charAt(si))
            {
                ti += 1;
            }
            if (ti == t.length()) return false;

            si += 1;
            ti += 1;
        }

        return si == s.length();       
    }
}