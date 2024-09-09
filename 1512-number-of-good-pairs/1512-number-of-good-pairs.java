class Solution {
    public int numIdenticalPairs(int[] nums) {
        var numToCount = new HashMap<Integer, Integer>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (numToCount.containsKey(current))
            {
                int count = numToCount.get(current);
                result += count;
                numToCount.put(current, count + 1);
            }
            else
            {
                numToCount.put(current, 1);
            }
        }


        return result;
    }
}