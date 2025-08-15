class Solution {
    public String addBinary(String a, String b) {
        
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        StringBuilder resultB = new StringBuilder();
        int carryOver = 0; 

        while (ia >= 0 || ib >= 0)
        {
            int bitA = ia < 0 ? 0 : a.charAt(ia) - '0';
            int bitB = ib < 0 ? 0 : b.charAt(ib) - '0';

            int sum = bitA + bitB;

            if (sum  == 0)
            {
                resultB.append(carryOver == 0 ? 0 : 1);
                carryOver = Math.max(0, carryOver - 1);
            } else if (sum == 1)
            {
                if (carryOver == 0)
                {
                    resultB.append(1);
                } else {
                    resultB.append(0);
                }
            } else if (sum == 2)
            {
                if (carryOver == 0)
                {
                    resultB.append(0);
                    carryOver += 1;
                } else {
                    resultB.append(1);
                    carryOver += 1;
                }
            }


            ia -= 1;
            ib -= 1;
        }

        // while (carryOver > 0)
        // {
        //     resultB.append(carryOver % 2);
        //     carryOver /= 2;
        // }

        if (carryOver > 0)
        {
            resultB.append(1);
        }

        return resultB.reverse().toString();
    }
}