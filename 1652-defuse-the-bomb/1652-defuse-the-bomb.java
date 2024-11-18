class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];

        int start = 1;
        int end = k;
        if ( k < 0)
        {
            start = code.length + k;
            end = code.length - 1;
        }
        
        int sum = 0;
        for (int i=start; i<=end; i++)
        {
            sum += code[i];
        }

        int[] result = new int[code.length];
        result[0] = sum;
        for (int i=1; i<result.length; i++)
        {
            result[i] = result[i-1] - code[start] + code[(end + 1) % code.length];
            start = (start + 1) % code.length;
            end = (end + 1) % code.length; 
        }

        return result;
    }
}