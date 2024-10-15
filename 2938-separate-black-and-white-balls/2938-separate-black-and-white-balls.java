class Solution {
    public long minimumSteps(String s) {

        if (s.length() < 2) return 0L;

        char[] chars = s.toCharArray();

        int lo = 0;
        int hi = lo + 1;
        long result = 0L;

        while (lo < chars.length && hi < chars.length)
        {
            if (chars[lo] - '0' == 0)
            {
                lo++;
            } 
            else 
            {
                while (hi < chars.length && chars[hi] - '1' == 0)
                {
                    hi++;
                }
                if (hi == chars.length)
                {
                    // lo == 1 and there are only 1-s to the right of it
                    return result;
                }

                // swap lo and hi, record swap length
                // move hi one position right, as there are no 0-s to the left of it 
                result += hi - lo;
                chars[hi] = '1';
                chars[lo] = '0';
                lo++;
                hi++;
            }

        }

        return result;


    }
}