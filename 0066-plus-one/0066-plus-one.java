class Solution {
    public int[] plusOne(int[] digits) {

        int carryOver = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int resd = digits[i] + carryOver;
            digits[i] = resd % 10;
            carryOver = resd / 10;
        }

        if (carryOver == 0)
        {
            return digits;
        }

        int[] shiftedDigits = new int[digits.length + 1];
        shiftedDigits[0] = carryOver;

       System.arraycopy(digits, 0, shiftedDigits, 1, digits.length);
        // for (int i = 0; i < digits.length; i++)
        // {
        //     shiftedDigits[i+1] = digits[i];
        // }
        return shiftedDigits;
    }
}