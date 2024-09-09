class Solution {
    List<List<Integer>> output = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        for (int size = 0; size < nums.length + 1; ++size) {
            backtrack(0, size, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    private void backtrack(int first, int size, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == size) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < nums.length; ++i) {
            // Add i into the current combination
            curr.add(nums[i]);

            // Use the next integers to complete the combination
            backtrack(i + 1, size, curr, nums);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}