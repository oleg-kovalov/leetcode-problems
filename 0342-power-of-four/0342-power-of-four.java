class Solution {
    public boolean isPowerOfFour(int n) {

        if (n <= 0) return false;

        // n & (n-1) turn off rightmost bit
        // if the number is power of 2 there is only one active bit,
        // so turning it off should equate to 0
        if ((n & (n-1)) != 0) return false;

        // by now we know the number is power of 2, it can be power of 4 or not.
        // if it's power or 2 then bit is on odd position,
        // if power of 4 - bit is on even position
        // we can & with mask, that turns off all odd positions
        if ((n & 0b01010101010101010101010101010101) == 0) return false;

        return true;

    }
}