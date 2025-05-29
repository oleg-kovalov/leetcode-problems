class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
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
        
        int nextIdx = idx;
        while (nextIdx < candidates.length && candidates[nextIdx] == candidates[idx]) 
            nextIdx += 1;
                
        // skip any count of current num
        backtrack(candidates, nextIdx, target, currRes, result);

        // try all possible counts of current num
        int num = candidates[idx];
        int count = nextIdx - idx;
        for (int i=0; i<count; i++)
        {
            currRes.add(num);
            backtrack(candidates, nextIdx, target - num * (i + 1), currRes, result);
        }
        for (int i=0; i<count; i++)
        {
            currRes.remove(currRes.size() - 1);
        }

    }

}


//           [1,1,6,7,10]
//                       []
//  [1]                [1,1]       [6]
//  [1,6]       [1,1,6]