class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permuteWithBacktracking(new LinkedList<>(), nums);

        return result;
    }

    private void permuteWithBacktracking(LinkedList<Integer> permutation, int[] nums)
    {
        for (int i=0; i<nums.length; i++)
        {
            final int num = nums[i];
            if (! permutation.contains(num))
            {
                permutation.add(num);
                permuteWithBacktracking(permutation, nums);
            }
        }

        if (permutation.size() == nums.length)
        {
            // System.out.println(permutation);
            result.add(new ArrayList<>(permutation));
        }

        if (! permutation.isEmpty()) permutation.removeLast();
    }
}