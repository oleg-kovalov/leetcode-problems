class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length - 1];
        int[] dp = new int[last + 1];

        int i=0;
        for (int day=1; day < dp.length; day++)
        {
            if (day != days[i]) {
                dp[day] = dp[day-1];
                continue;
            }

            i += 1;
            int pay1 = costs[0] + dp[day - 1];
            int pay7 = costs[1] + (day < 7 ? 0 : dp[day - 7]); 
            int pay30 = costs[2] + (day < 30 ? 0 : dp[day - 30]); 
            dp[day] = Math.min(pay1, Math.min(pay7, pay30));

        }

        return dp[last];

    }

}