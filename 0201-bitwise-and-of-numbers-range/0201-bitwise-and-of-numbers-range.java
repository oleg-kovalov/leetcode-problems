class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0) return 0;

        long loPower2 = 1;
        while (loPower2 <= left)
        {
             loPower2 <<= 1;
        }
        loPower2 >>= 1;

        long hiPower2 = (loPower2 << 1);
        if (right >= hiPower2)
        {
            return 0;
        }

        int result = left;
        for (long i=((long)left)+1; i<=right;i++)
        {
            result &= i;
        }
        return result;
    }
}