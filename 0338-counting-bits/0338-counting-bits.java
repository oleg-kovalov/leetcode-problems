class Solution {
    public int[] countBits(int n) {
        if (n == 0) return new int[] {0};

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        int pow = 1;

        for (int i=2; i<result.length; i++)
        {
            if (i == pow * 2)
            {
                result[i] = 1;
                pow *= 2;
            } else {
                result[i] = 1 + result[i - pow]; 
            }
        }

        System.out.println(Arrays.toString(result));

        return result;
    }
}