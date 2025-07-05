class Solution {
    public int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer> numToLen = new HashMap<>();

        for (int num: nums)
        {
            int len = 1;
            for (Map.Entry<Integer, Integer> entry: numToLen.entrySet())
            {
                if (entry.getKey() >= num) continue;
                len = Math.max(len, entry.getValue() + 1);
            }
            numToLen.put(num, len);
        }

        int result = 1;
        for (int value: numToLen.values())
        {
            result = Math.max(result, value);
        }

        return result;
    }
}