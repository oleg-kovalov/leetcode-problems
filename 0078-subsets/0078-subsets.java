class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, new ArrayList<>(), nums, result);

        return result;
    }

    private void backtrack(int i, List<Integer> list, int[] nums, List<List<Integer>> result) 
    {
        if (i >= nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }


        // include num
        list.add(nums[i]);
        backtrack(i + 1, list, nums, result);
        list.remove(list.size()-1);

        // don't include num
        backtrack(i + 1, list, nums, result);
    }

}