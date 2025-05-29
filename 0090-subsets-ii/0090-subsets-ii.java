class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> result)
    {
        if (idx == nums.length)
        {
            result.add(new ArrayList<>(subset));
            return;
        }


        int num = nums[idx];
        int nextIdx = idx;
        while (nextIdx < nums.length && nums[nextIdx] == num)
            nextIdx += 1;

        // skip current num
        backtrack(nums, nextIdx, subset, result);

        int count = nextIdx - idx;
        for (int i=0; i<count; i++)
        {
            subset.add(num);
            backtrack(nums, nextIdx, subset, result);
        }
        for (int i=0; i<count; i++)
        {
            subset.remove(subset.size() - 1);
        }
    }
}