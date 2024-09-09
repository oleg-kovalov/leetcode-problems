class Solution {
        public String addBinary(String a, String b)
        {

            StringBuilder result = new StringBuilder();
            int ai = a.length() - 1;
            int bi = b.length() - 1;
            int carryover = 0;

            while (ai >= 0 || bi >= 0)
            {
                int av = ai >=0 ? a.charAt(ai) - '0' : 0;
                int bv = bi >=0 ? Character.getNumericValue(b.charAt(bi)) : 0;

                int sum = av + bv + carryover;
                if (sum == 2) {
                    sum = 0;
                    carryover = 1;
                } else if (sum == 3)
                {
                    sum = 1;
                    carryover = 1;
                } else {
                    carryover = 0;
                }

                result.append(sum);

                ai--;
                bi--;
            }

            if (carryover == 1)
            {
                result.append(carryover);
            }


            return result.reverse().toString();
        }
}