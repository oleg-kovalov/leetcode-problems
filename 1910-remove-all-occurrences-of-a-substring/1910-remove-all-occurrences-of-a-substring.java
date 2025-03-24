class Solution {
    public String removeOccurrences(String s, String part) {
        String newstr = s;
        while (s.indexOf(part) >= 0)
        {
            int index = newstr.indexOf(part);
            newstr = s.substring(0, index);
            if (index + part.length() < s.length()) {
                newstr += s.substring(index + part.length(), s.length());
            }
            s = newstr;
        }

        return newstr;
    }
}