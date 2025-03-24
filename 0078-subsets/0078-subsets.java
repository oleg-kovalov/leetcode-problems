class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        backtrack(0, new ArrayList<>(), nums);

        return result;
    }

    private void backtrack(int idx, List<Integer> curr, int[] nums) 
    {
        if (idx == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        //add
        curr.add(nums[idx]);
        backtrack(idx + 1, curr, nums);
        curr.remove(curr.size()-1);

        //don't add
        backtrack(idx + 1, curr, nums);
        
    }



}