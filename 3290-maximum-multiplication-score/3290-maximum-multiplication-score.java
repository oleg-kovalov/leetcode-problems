class Solution {

        Long[][] memo;
        public long maxScore(int[] a, int[] b)
        {
            memo = new Long[a.length][b.length];
            return recursion(0, 0, a, b);
        }

        private long recursion(int ia, int ib, int[] a, int[] b)
        {
            if (ia == a.length) return 0;
            if (ib >= b.length) return (long) -1e9; //Long.MIN_VALUE; //invalid path

            if (memo[ia][ib] != null) return memo[ia][ib];
            
            long take =  1L * a[ia] * b[ib] + recursion(ia + 1, ib + 1, a, b);
            long noTake = recursion(ia, ib + 1, a, b);

            long result = Math.max(take, noTake);
            memo[ia][ib] = result;
            return result;
        }

    
}