class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        boolean[] precompute = new boolean[2050];
        for (int j=0; j < nums.length; j++)
        {
            for (int k=j; k < nums.length; k++)
            {
                precompute[nums[j] ^ nums[k]] = true;;
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i=0; i< nums.length; i++)
        {
            for (int l=0; l<precompute.length; l++)
            {
                if (precompute[l]) result.add(nums[i] ^ l);
            }
        }

        return result.size();
    }
}