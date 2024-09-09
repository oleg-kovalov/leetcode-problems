class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        int wordBegin = -1;

        for (int i=0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
            {
                if (wordBegin < 0) {
                    wordBegin = i;
                }
            }
            else
            {
                if (wordBegin >= 0)
                {
                    for (int j=i-1; j >=wordBegin;j--)
                    {
                        result.append(s.charAt(j));
                    }
                    wordBegin = -1;
                }
                result.append(' ');
            }
        }

        if (wordBegin >= 0)
        {
            for (int j=s.length() -1; j >=wordBegin;j--)
            {
                result.append(s.charAt(j));
            }
        }

        return result.toString();
    }
}