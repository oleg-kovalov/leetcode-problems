class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumBacktracking(0, new ArrayList<>(), candidates, target);

        return result;
    }

    private void combinationSumBacktracking(int start, List<Integer> combination, int[] candidates, int target)
    {
        // System.out.println(combination);
        if (target == 0)
        {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0)
        {
            return;
        }

        for (int i=start; i<candidates.length; i++)
        {
            final int candidate = candidates[i];

            combination.add(candidate);
            target -= candidate;

            combinationSumBacktracking(i, combination, candidates, target);

            combination.remove(combination.size()-1);
            target += candidate;
        }

    }
}