class Solution {
    public int lengthOfLIS(int[] nums) {

        // index of first element to subsequence
        Map<Integer, Integer> cachedIS = new HashMap<>();

        for (int c=nums.length-1; c >=0; c--)
        {
            int current = nums[c];
            cachedIS.put(c, 1);
            for (int n=c+1; n<nums.length; n++)
            {
                if (current >= nums[n])
                {
                    continue;
                }

                if (cachedIS.containsKey(n)) {
                    Integer isLength = cachedIS.get(n);
                    cachedIS.merge(c, isLength+1, Integer::max);
                }

            }
        }

        int maxIS = cachedIS.values().stream().mapToInt(Integer::intValue).max().orElse(1);

        return maxIS;

    }
}