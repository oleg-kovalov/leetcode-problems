class Solution {
    public int hammingWeight(int n) {
        
        int count = 0;
        int position = 0;
        int mask = (1 << position);
        while (0 <= mask && mask <= n)
        {
            if ((n & mask) > 0)
            {
                count += 1;
            }
            position += 1;
            mask = (1 << position);
        }

        return count;
    }
}