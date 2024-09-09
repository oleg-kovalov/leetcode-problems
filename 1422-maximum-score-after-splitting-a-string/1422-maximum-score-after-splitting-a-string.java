class Solution {
    public int maxScore(String s) {
        // result = leftZero + rightOnes 
        // => leftZero - leftOnes + totalOnes 
        // => bestLeft + totalOnes

        int leftZero = 0;
        int leftOnes = 0;
        int bestLeft = Integer.MIN_VALUE;

        for (int i=0; i<s.length()-1; i++)
        {
            if (s.charAt(i) - '1' == 0)
            {
                leftOnes++;
            } else {
                leftZero++;
            }

            bestLeft = Math.max(bestLeft, leftZero - leftOnes);
        }

        int totalOnes = leftOnes + (s.charAt(s.length()-1) - '1' == 0 ? 1 : 0);

        return bestLeft  + totalOnes ;

    }
}