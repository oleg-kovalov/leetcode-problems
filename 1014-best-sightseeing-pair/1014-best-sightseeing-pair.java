class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best = Integer.MIN_VALUE;

        int valPlusIdxI = 0;
        for (int i=0; i<values.length; i++)
        {
            best = Math.max(best, valPlusIdxI + values[i] - i);        
            valPlusIdxI = Math.max(valPlusIdxI, values[i] + i);
        }

        return best;
    }
}