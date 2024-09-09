class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int[] keyDigits = new int[4];

        int denominator = 1000;
        for (int i=0; i<keyDigits.length; i++)
        {
            keyDigits[i] = Math.min(num1 / denominator, Math.min(num2 / denominator, num3 / denominator));
            num1 %= denominator;
            num2 %= denominator;
            num3 %= denominator;
            denominator /= 10;
        }

        int key = 0;
        int numerator = 1;
        for (int i = keyDigits.length-1; i >= 0; i--)
        {
            key += keyDigits[i] * numerator;
            numerator *= 10;
        }

        return key;


    }
}