class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> monsterTimesAsc = new PriorityQueue<>(); //ASC
        for (int i=0; i<dist.length; i++)
        {
            int reachingTime = (int) Math.ceil((double)dist[i] / speed[i]);
            monsterTimesAsc.add(reachingTime);
        }

        int t=0;
        while (monsterTimesAsc.size() > 0)
        {
            int monsterTime = monsterTimesAsc.poll();
            if (t >= monsterTime)
            {
                return t;
            }
            t++;
        }


        return t;
    }
}