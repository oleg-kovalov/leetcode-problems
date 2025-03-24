class Solution {
    public int rotatedDigits(int n) {
        Set<Integer> invalidSet = Set.of(3,4,7);
        Set<Integer> goodSet = Set.of(2,5,6,9);

        int result = 0; //1
        for (int i=1; i<=n; i++)
        {
            int num = i;
            boolean good = false;
            boolean invalid = false;
            while (num > 0)
            {
                int digit = num % 10; //2
                if (invalidSet.contains(digit))
                {
                    invalid = true;
                    break;
                }
                if (goodSet.contains(digit))
                {
                    good = true; //true
                }
                num /= 10;
            }
            if (good && !invalid) result += 1;
        }


        return result;
    }
}