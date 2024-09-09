class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWait = 0L;

        int shefBusy = 0;
        for (final int[] customer : customers)
        {
            int arriveTime = customer[0];
            int foodTime = customer[1];

            final int waitTime;
            if (arriveTime > shefBusy)
            {
                waitTime = foodTime;
                shefBusy = arriveTime + foodTime;
            } else {
                waitTime = foodTime + (shefBusy - arriveTime);
                shefBusy = shefBusy + foodTime;
            }

            totalWait += waitTime;
        }

        return (double) totalWait / customers.length;
    }
}