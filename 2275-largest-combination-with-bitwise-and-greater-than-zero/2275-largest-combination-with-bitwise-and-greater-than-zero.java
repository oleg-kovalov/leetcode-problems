class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[24];

        for (int num : candidates) {
            int pos = 0;
            while (num > 0) {
                if ((num | 1) == num) {
                    bits[pos] += 1;
                }
                pos += 1;
                num >>= 1;
            }
        }

        int maxBits = 0;
        for (int bitCount : bits) {
            maxBits = Math.max(maxBits, bitCount);
        }

        return maxBits;
    }
}