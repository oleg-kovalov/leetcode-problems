class Solution {
    public int mySqrt(int x) {

        return findSqrt(0, x/2 + 1, x);
    }

    private int findSqrt(int start, int end, int x)
    {
        if (end - start < 2) {
            if ((long)end * end == x) {
                return end;
            } else {
                return start;
            }
        }

        int middle = (end + start) / 2 ;
        if ((long)middle * middle < x) {
            return findSqrt(middle, end, x);
        } else {
            return findSqrt(start, middle, x);
        }
    }
}
