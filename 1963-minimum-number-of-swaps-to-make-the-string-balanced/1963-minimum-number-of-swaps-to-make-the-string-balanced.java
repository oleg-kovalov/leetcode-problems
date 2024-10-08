class Solution {
    public int minSwaps(String s) {

        char[] brackets = s.toCharArray();

        int start = 0;
        int end = brackets.length -1;
        int openCount = 0;
        int closeCount = 0;
        int swapCount = 0;

        while (start < end)
        {
            char left = brackets[start];
            if (left - '[' == 0)
            {
                openCount++;
            } else {
                closeCount++;
            }

            if (closeCount > openCount)
            {
                // swap left ] with rightmost [
                while (brackets[end] - '[' != 0)
                {
                    end--;
                }

                char right = brackets[end];
                brackets[end] = left;
                brackets[start] = right;
                swapCount++;

                openCount++;
                closeCount--;
            }
            start++;
        }

        return swapCount;
    }
}