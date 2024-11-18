class Solution {
    public int[] decrypt(int[] code, int k) {
        if (code.length == 1) return new int[1];
    
        if (k == 0) 
        {
            return new int[code.length];
        } else if (k > 0)
        {
            int sum = 0;
            for (int i=1; i<k+1; i++)
            {
                sum += code[i];
            }

            int[] result = new int[code.length];
            result[0] = sum;
            for (int i=1; i<result.length; i++)
            {
                result[i] = result[i-1] - code[i] + code[(i + k) % result.length];
            }
            return result;
        } else {
            int sum = 0;
            for (int i=code.length-2; i>=code.length - 2 + k + 1; i--)
            {
                sum += code[i];    
            }

            int[] result = new int[code.length];
            result[result.length - 1] = sum;
            for (int i=result.length -2; i>=0; i--)
            {
                result[i] = result[i+1] - code[i] + code[(result.length + i + k) % result.length];
            }

            return result;
    

        }

    }
}