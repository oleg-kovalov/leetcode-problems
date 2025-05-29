class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates, int idx, int target, List<Integer> currRes, List<List<Integer>> result)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(currRes));
            return;
        }
        if (target < 0) return;
        if (idx >= candidates.length) return;
        
        // choose num at index
        currRes.add(candidates[idx]);
        backtrack(candidates, idx, target - candidates[idx], currRes, result);
        currRes.remove(currRes.size() - 1);

        // don't choose num at index, move index forward
        backtrack(candidates, idx + 1, target, currRes, result);
    }

    //                          [], 7
    //  [2],5              [3], 4,   [6], 1   [7],0   
    //[2,2],3 [2,3],2

    // [2,2,3], [2,3,2]  [3,2,2]  => [2,2,3]
    //
    //           [2,3,6,7]
    //            ^
    //   [2,3,6,7]       [2,3,6,7]
    //    ^                 ^

}