class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z'))
            {
                sb.append(c);
            }
        }

        String cleanStr = sb.toString().toLowerCase();

        int l = 0;
        int r = cleanStr.length()-1;
        while (l < r)
        {
            if (cleanStr.charAt(l) != cleanStr.charAt(r)) return false;

            l++;
            r--;
        }

        return true;

    }
}