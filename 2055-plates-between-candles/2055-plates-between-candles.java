class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {

        int[] plates = new int[s.length()];
        int[] leftCandles = new int[s.length()];

        if (s.charAt(1) - '*' == 0) {
            plates[0] = 1;
            leftCandles[0] = -1;
        } else {
            plates[0] = 0;
            leftCandles[0] = 0;
        }

        for (int i=1; i<s.length(); i++)
        {
            if (s.charAt(i) - '*' == 0)
            {
                plates[i] = plates[i-1] + 1;
                leftCandles[i] = leftCandles[i-1];
            } else {
                plates[i] = plates[i-1];
                leftCandles[i] = i;
            }
        }


        int[] rightCandles = new int[s.length()];

        if (s.charAt(s.length() -1) - '*' == 0)
        {
            rightCandles[s.length()-1] = -1;
        } else {
            rightCandles[s.length()-1] = s.length()-1;
        }

        for (int i=s.length()-2; i>=0; i--)
        {
            if (s.charAt(i) - '*' == 0)
            {
                rightCandles[i] = rightCandles[i+1];
            } else {
                rightCandles[i] = i;
            }
        }


        int[] result = new int[queries.length];
        for (int q=0; q<queries.length; q++)
        {
            int leftCandle = rightCandles[queries[q][0]];
            int rightCandle = leftCandles[queries[q][1]]; 
            if (leftCandle >= rightCandle)
            {
                result[q] = 0;
                continue;
            }

            result[q] = plates[rightCandle] - plates[leftCandle];
        }
        

        return result;
    
    }

}