class Solution {
    int[] days;
    int[] costs;
    HashMap<Integer, Integer> memo;
    HashSet<Integer> isTravelNeeded = new HashSet<>();
    HashSet<Integer> travelDays = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;

        for (int day: days) travelDays.add(day);
        
        memo = new HashMap<>();

        return rec(1);
    }

    private int rec(int curr) {
        if (curr > days[days.length - 1]) return 0;

        if (!travelDays.contains(curr)) return rec(curr + 1);

        if (memo.containsKey(curr)) return memo.get(curr);

        int oneDay = costs[0] + rec(curr + 1);
        int sevenDay = costs[1] + rec(curr + 7);
        int thirtyDay = costs[2] + rec(curr + 30);

        int result = Math.min(oneDay, Math.min(sevenDay, thirtyDay));

        memo.put(curr, result);

        return result;
    }


}