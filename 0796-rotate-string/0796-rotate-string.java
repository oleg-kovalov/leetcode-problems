class Solution {
        public boolean rotateString(String s, String goal)
        {
            if (s.length() != goal.length()) return false;

            String doubleStr = s + s;

            return kmpSearch(doubleStr, goal);

        }

        private boolean kmpSearch(String text, String pattern)
        {
            int[] lps = computeLPS(pattern);
            int textIndex = 0;
            int patternIndex = 0;

            while (textIndex < text.length())
            {
                if (text.charAt(textIndex) == pattern.charAt(patternIndex))
                {
                    textIndex++;
                    patternIndex++;
                    if (patternIndex == pattern.length()) return true;
                }
                else if (patternIndex > 0)
                {
                    patternIndex = lps[patternIndex - 1];
                }
                else {
                    textIndex++;
                }
            }

            return false;
        }

        private int[] computeLPS(String pattern)
        {
            int[] lps = new int[pattern.length()];
            int length = 0;
            int index = 1;

            while (index < pattern.length())
            {
                if (pattern.charAt(index) == pattern.charAt(length))
                {
                    length++;
                    lps[index] = length;
                    index++;
                }
                else {
                    if (length > 0)
                    {
                        length = lps[length - 1];
                    } else {
                        lps[index] = 0;
                        index++;
                    }
                }
            }

            return lps;
        }
}