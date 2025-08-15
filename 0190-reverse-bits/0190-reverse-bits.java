class Solution {
    public int reverseBits(int n) {
        
        int result = (n & 1);
        n >>= 1;
        for (int i=1; i<32; i++)
        {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }

        return result;
    }
}