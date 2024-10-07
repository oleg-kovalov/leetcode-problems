class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        long num = Math.abs(x);
        long remainder = 0L;
        long result = 0L;

        while (num > 0)
        {
            remainder = num % 10;
            num /= 10;
            result = result * 10 + remainder;
        }
        
        result *= neg ? -1 : 1;
        
        if (Integer.MIN_VALUE <= result && result <= Integer.MAX_VALUE ) return (int) result;

        return 0;
    }
}