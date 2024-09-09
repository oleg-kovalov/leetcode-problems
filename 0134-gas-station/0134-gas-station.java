class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int currGain = 0;
        int totalGain = 0;

        for (int i = 0; i < gas.length; i++) {
            // gain[i] = gas[i] - cost[i];
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i]; // petrol in tank at this moment

            // if we meet a "valley", start over from next station
            if (currGain < 0) {
                start = i + 1;
                currGain = 0;
            }
        }

        if (totalGain < 0)
            return -1; // there is not enough petrol to finish circle from any station.

        return start; // there is theoretically enough fuel and we re-started after each deep "valley"
        // so we must have found the answer. As we are moving by circle, we'll cross
        // deep valleys starting earlier
    }

}