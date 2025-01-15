class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int[] bits1 = new int[30];
        int count1 = 0;
        for (int i=0; i<bits1.length; i++)
        {
            if ((num1 & (1 << i)) > 0)
            {
                bits1[i] = 1;
                count1 += 1;
            } else {
                bits1[i] = 0;
            }
        }

        int[] bits2 = new int[30];
        int count2 = 0;
        for (int i=0; i<bits2.length; i++)
        {
            if ((num2 & (1 << i)) > 0)
            {
                bits2[i] = 1;
                count2 += 1;
            } else {
                bits2[i] = 0;
            }
        }

        if (count1 == count2) 
        {
            return num1;
        }

        if (count1 > count2)
        {
            int result = 0;
            int extraBits = count2;
            for (int i=bits1.length - 1; i >= 0; i--)
            {
                if (bits1[i] == 1)
                {
                    result |= (1 << i);
                    extraBits -= 1;
                }
                if (extraBits == 0) return result;
            }
        }
        else {
            int result = num1;
            int extraBits = count2 - count1;
            int i=0; 
            while (extraBits > 0 && i < bits1.length)
            {
                if (bits1[i] == 0)
                {
                    result |= (1 << i);
                    extraBits -= 1;
                }
                i += 1;
            }
            return result;
        }

        return -1;
    }
}