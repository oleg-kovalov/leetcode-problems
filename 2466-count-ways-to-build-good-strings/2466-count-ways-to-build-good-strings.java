class Solution {
    int low;
    int high;
    int zero;
    int one;
    HashMap<String, Long> memo;
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;
        memo = new HashMap<>();

        long result = backtracking(new StringBuilder(), 0);

        return (int)result % 1_000_000_007;
    }

    private long backtracking(StringBuilder str, int length)
    {
        if (length > high) return 0;
        if (memo.containsKey(str.toString())) return memo.get(str.toString());

        long count = (length >= low ? 1 : 0) 
            + backtracking(str.append('0'), length + zero)
            + backtracking(str.append('1'), length + one);
        
        memo.put(str.toString(), count);
        return count;
    }
    
}