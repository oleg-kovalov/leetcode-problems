class Solution {
    private HashMap<String, Integer> cache = new HashMap<>();

    public int maxOperations(int[] nums) {
        if (nums.length == 2) return 1;

        int length = nums.length;

        return Math.max(
            dpRec(2, length-1, nums, nums[0] + nums[1], 1),
            Math.max(
                dpRec(0, length-3, nums, nums[length-1] + nums[length-2], 1),
                dpRec(1, length-2, nums, nums[0] + nums[length-1], 1)));
    }

    private int dpRec (int lo, int hi, int[] nums, final int score, int count)
    {
        final String cacheKey = lo + "_" + hi;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        if (hi == lo + 1)
        {
            if (nums[lo] + nums[hi] == score)
            {
                cache.put(cacheKey, count+1);
                return count+1;
            } else {
                cache.put(cacheKey, count);
                return count;
            }
        }

        if (hi == lo)
        {
            cache.put(cacheKey, count);
            return count;
        }


        int result = count;
        if (nums[lo] + nums[lo+1] == score)
        {
            result = Math.max(result, dpRec(lo+2, hi, nums, score, count+1));
        }
        if (nums[hi] + nums[hi-1] == score)
        {
            result = Math.max(result, dpRec(lo, hi-2, nums, score, count+1));
        }
        if (nums[lo] + nums[hi] == score)
        {
            result  = Math.max(result, dpRec(lo+1, hi-1, nums, score, count+1));
        }

        cache.put(cacheKey, result);
        return result;

    }
}