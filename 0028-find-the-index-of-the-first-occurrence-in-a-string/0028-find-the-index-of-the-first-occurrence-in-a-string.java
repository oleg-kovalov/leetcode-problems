class Solution {
    public int strStr(String haystack, String needle) {
        
        for (int i=0; i < haystack.length() - needle.length() + 1; i++)
        {
            for (int j=i; j < i + needle.length(); j++ )
            {
                if (haystack.charAt(j) != needle.charAt(j-i))
                {
                    break;
                }
                if (j == i + needle.length() -1 )
                {
                    return i;
                }
            }
        }

        return -1;
    }
}