class Solution {
    public int minBitFlips(int start, int goal)
    {
        int xor = start ^ goal;

        int sum = 0;
        while (xor > 0)
        {
            if (xor == (xor | 1)) sum += 1;
            xor >>= 1;
        }


        return sum;
    }
}