class Solution {
    public int maximumSwap(int num) {
        if (num < 10) return num;

        int max = -1;
        List<int[]> digits = new ArrayList<>();
        while (num > 0)
        {
            int digit = num % 10;
            max = Math.max(max, digit); // max digit value among digits less or equal to current
            digits.add(new int[]{digit, max});
            num /= 10;
        }

        boolean swapDone = false;
        int result = 0;
        for (int i=digits.size()-1; i>=0; i--)
        {
            int digitValue = digits.get(i)[0];
            int maxToTheRight = digits.get(i)[1];

            if (!swapDone && digitValue < maxToTheRight)
            {
                for (int j=0; j < i; j++)
                {
                    if (digits.get(j)[0] == maxToTheRight)
                    {
                        digits.get(j)[0] = digitValue; // swap with the lowest possible digit 
                        swapDone = true;
                        break;
                    }
                }

                digitValue = maxToTheRight;                
            }

            result = result * 10 + digitValue;
        }

        return result;

    }
}