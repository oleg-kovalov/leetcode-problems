class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        // sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> a[0] - b[0]);

        // flatten factory positions according to capacities
        List<Integer> factoryPos = new ArrayList<>();
        for (int[] f: factory)
        {
            for (int cap=0; cap<f[1]; cap++)
            {
                factoryPos.add(f[0]);
            }
        }

        return backtrack(0, 0, robot, factoryPos);
    }

    private long backtrack(int robotId, int factoryId, List<Integer> robot, List<Integer> factoryPos)
    {
        // all robots repaired
        if (robotId == robot.size()) return 0;

        //no factories left
        if (factoryId == factoryPos.size()) return (long) 1e12;

        //option 1: assign current robot to current factory
        long assign = Math.abs(robot.get(robotId) - factoryPos.get(factoryId))
            + backtrack(robotId + 1, factoryId + 1, robot, factoryPos);

        //option 2: skip current factory
        long skip = backtrack(robotId, factoryId + 1, robot, factoryPos);

        return Math.min(assign, skip);
    }
}