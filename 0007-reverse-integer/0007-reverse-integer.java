class Solution {
    public int reverse(int x) {
        int remainder = 0;
        int result = 0;

        while (x != 0)
        {
            remainder = x % 10;
            x /= 10;

            if (Math.abs(result) > Integer.MAX_VALUE  / 10 ) return 0;

            result = result * 10 + remainder;
        }

        return result;

    }
}