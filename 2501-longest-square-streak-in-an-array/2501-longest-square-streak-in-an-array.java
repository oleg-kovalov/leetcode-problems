class Solution {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 1;
        int prev = -1;
        for (int num: nums)
        {
            if (num == prev) continue;

            if (count.containsKey(num))
            {
                int prevCount = count.remove(num);
                count.put(num * num, prevCount + 1);
            } else {
                count.put(num * num, 1);
            }

            prev = num;
        }

        for (int c: count.values())
        {
            maxCount = Math.max(maxCount, c);
        }
        return maxCount > 1 ? maxCount : -1;
    }
}