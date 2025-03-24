class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        int[] result = new int[nums.length - k + 1];
        for (int i=0; i<k; i++)
        {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = count.size();

        for (int i=1; i<result.length; i++)
        {
            int old = count.remove(nums[i-1]);
            if (old > 1)
            {
                count.put(nums[i-1], old - 1);
            }

            count.put(nums[i + k - 1], count.getOrDefault(nums[i + k - 1], 0) + 1);
            result[i] = count.size();
        }        

        return result;
    }
}