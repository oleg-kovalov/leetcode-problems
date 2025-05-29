class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backtrack(nums, 0);
    }

    private List<List<Integer>> backtrack(int[] nums, int idx)
    {
        if (idx == nums.length) 
        {
            List<List<Integer>> emptyListList = new ArrayList<>();
            emptyListList.add(new ArrayList<>());
            return emptyListList;
        }
        
        List<List<Integer>> permutations = backtrack(nums, idx + 1);
        // insert current num in all possible spots in partial permutation
        List<List<Integer>> nextPermutations = new ArrayList<>();
        for (List<Integer> perm: permutations)
        {
            for (int i=0; i<perm.size() + 1; i++)
            {
                List<Integer> nextPerm = new ArrayList<>(perm);
                nextPerm.add(i, nums[idx]);
                nextPermutations.add(nextPerm);
            }
        }

        return nextPermutations;
    }

}