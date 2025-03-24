class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();

        backtrack(1, new ArrayList<>(), n, k);

        return result;
        

    }

    private void backtrack(int num, List<Integer> curr, int n, int k)
    {
        if (curr.size() == k)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (num > n)
        {
            return;
        }

        // take
        curr.add(num);
        backtrack(num + 1, curr, n, k);
        curr.remove(curr.size()-1);

        //don't take
        backtrack(num + 1, curr, n, k);
    }
}