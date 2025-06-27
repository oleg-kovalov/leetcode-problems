class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(List.of(1));
        if (numRows == 1) return result;

        result.add(List.of(1,1));
        if (numRows == 2) return result;

        for (int i=2; i<numRows; i++)
        {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = result.get(result.size() - 1);

            curr.add(1);
            for (int j=1; j<prev.size(); j++)
            {
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);

            result.add(curr);
        }

        return result;
    }
}