class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i=0; i<nums.length; i++)
        {
            for (int j=i+1; j<nums.length; j++)
            {
                int prod = nums[i] * nums[j];
                freq.put(prod, freq.getOrDefault(prod, 0) + 1);
            }
        }

        int result = 0;
        for (int prod: freq.values())
        {
            if (prod > 1)
            {
                // n * (n-1) / 2 to find all distinct products
                // x8 to find all permutations:
                // A=B, A!=B, A=!B, A!=B!
                // B=A, B=A!, B!=A, B!=A!
                result +=  8 * (prod * (prod - 1) / 2);
            }
        }

        return result;
    }
}