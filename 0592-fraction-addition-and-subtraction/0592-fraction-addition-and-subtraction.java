class Solution {
        public String fractionAddition(String expression)
        {
            final String[] nums = expression.split("/|(?=[+-])");

            int runningNum = 0;
            int runningDenom = 1;

            for (int i = 0; i < nums.length; i+= 2)
            {
                int currentNum = Integer.parseInt(nums[i]);
                int currentDenom = Integer.parseInt(nums[i+1]);

                runningNum = runningNum * currentDenom + currentNum * runningDenom;
                runningDenom *= currentDenom;
            }

            //reduce fraction
            int gcd = Math.abs(gcdShort(runningNum, runningDenom));

            runningNum /= gcd;
            runningDenom /= gcd;

            return runningNum + "/" + runningDenom;

        }

        // Euclidean algorithm: if we subtract smaller number from greater, GCD will not change
        private int gcdSubtracting(int a, int b)
        {
            if (a == 0) return b;
            if (b == 0) return a;

            if (a == b) return a;

            if (a > b)
            {
                return gcdSubtracting(a - b, b);
            } else {
                return gcdSubtracting(a, b - a);
            }
        }

        //Euclidean algorithm optimization: to speed-up subtracting we can take remainder of division R,
        // thinking that if A > B then A = B * Q + R.

        private int gcdDividing(int a, int b)
        {
            if (a == 0) return b;
            if (b == 0) return a;

            if (Math.abs(a) > Math.abs(b))
            {
                return gcdDividing(a % b, b);
            }
            else
            {
                return gcdDividing(a, b % a);
            }
        }

        public static int gcdShort(int a, int b)
        {
            if (a == 0) return b;
            return gcdShort(b % a, a);
        }


}