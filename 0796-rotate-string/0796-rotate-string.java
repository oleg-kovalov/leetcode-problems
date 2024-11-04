class Solution {
    public boolean rotateString(String s, String goal) {
        if (goal.length() != s.length()) return false;
        
        char g1 = goal.charAt(0);
        int start = s.indexOf(g1);
        if (start == -1) return false;

        int j=1;
        int i=start+1;
        if (i == s.length()) i=0;
        while (j < goal.length())
        {
            if (i == start && j == 0) return false;

            if (s.charAt(i) == goal.charAt(j))
            {
                j++;
                i++;
                if (i == s.length()) i=0;
            } else {
                i = s.indexOf(g1, i);
                if ( i == -1 ) return false;
                j = 0;
            }
        }

        return true;
    }
}