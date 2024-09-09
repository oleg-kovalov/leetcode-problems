class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();

        int startIdx = -1;
        int endIdx = -1;

        for (int i=chars.length-1; i >=0; i--)
        {
            if (chars[i] - ' ' != 0)
            {
                endIdx = i;
                break;
            }
        }

        if (endIdx == -1) {
            return 0;
        }

        for (int i=endIdx; i >=0; i--)
        {
            if (chars[i] - ' ' == 0)  // Character.isWhitespace(chars[i])
            {
                startIdx = i+1;
                break;
            }
            else if (i == 0)
            {
                startIdx = 0;
                break;
            }
        }

        return endIdx - startIdx + 1;

    }

}