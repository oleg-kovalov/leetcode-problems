class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        int idx1 = 0;
        for (int i=0; i<str2.length(); i++)
        {
            char targetChar = str2.charAt(i);
            while (idx1 < str1.length() && str1.charAt(idx1) - targetChar != 0 && str1.charAt(idx1) - (targetChar - 'a' == 0 ? 'z' : targetChar - 1) != 0)
            {
                idx1++;
            }

            if (idx1 == str1.length()) return false;
            idx1++;
        }        

        return true;
    }
}