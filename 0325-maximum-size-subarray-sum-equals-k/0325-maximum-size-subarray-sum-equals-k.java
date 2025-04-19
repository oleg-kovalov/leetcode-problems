class Solution {
    public int maxSubArrayLen(int[] nums, int k) { // -2 -1 2 1

        int[] prefix = new int[nums.length + 1]; // 0 -2 -3 -1 0
        for (int i=1; i<prefix.length; i++)
        {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        int result = 0;
        Map<Integer,Integer> complMap = new HashMap<>();  // prefix -> index   // 0 -> 0  -2-> 1
        for (int i=0; i<prefix.length; i++)
        {
            int pfx = prefix[i]; // -3
            if (complMap.containsKey(pfx - k))
            {
                result = Math.max(result, i - complMap.get(pfx - k));
            }
            if (!complMap.containsKey(pfx))
            {
                complMap.put(pfx, i);
            }
        }

        return result;

    }
}