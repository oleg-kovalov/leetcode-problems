class Solution {
    private final Set<Integer> corners = Set.of(1, 3, 7, 9);
    private final Set<Integer> mids = Set.of(2, 4, 6, 8);
    private int result;

    public int numberOfPatterns(int m, int n) {
        result = 0;

        for (int i=1; i<=9; i++)
        {
            backtrack(new HashSet<>(), -1, i, m ,n);
        }

        return result;
    }

    private void backtrack(Set<Integer> path, int prev, int next, int m, int n )
    {
        if (path.contains(next))
        {
            return;
        }
        if ((prev != -1) && mids.contains(next) && (prev + next == 10) && !path.contains(5))
        {
            return;
        }
        if ((prev != -1) && corners.contains(next) && corners.contains(prev) && !path.contains((prev + next) / 2))
        {
            return;
        }

        path.add(next);

        if (path.size() > n) {
            path.remove(next);
            return;
        }

        if (path.size() >= m) {
//            System.out.println(path);
            result += 1;
        }

        for (int i=1; i<=9; i++)
        {

            backtrack(path, next, i, m, n);
        }

        path.remove(next);

    }
}