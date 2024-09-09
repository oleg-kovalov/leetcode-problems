class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);

        backtracking(new ArrayList<>(), target, candidates, 0);

        return result;
    }

    private void backtracking(List<Integer> combination, int remainder, int[] candidates, int startFrom)
    {
        if (remainder < 0) return;
        if (remainder == 0)
        {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startFrom; i < candidates.length; i++)
        {
            final Integer candidate = candidates[i];
            if ((i > startFrom) && candidate.equals(candidates[i-1]))
            {
                continue;
            }
            combination.add(candidate);

            backtracking(combination, remainder - candidate, candidates, i+1);

            combination.remove(candidate);
        }
    }
}