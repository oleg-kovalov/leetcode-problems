class Solution {
        int[] cache = new int[1024]; // 2^10 states for 10 bikes

        public int assignBikes(int[][] workers, int[][] bikes) {
            Arrays.fill(cache, -1);

            return findMinDistanceRec(workers, bikes, 0, 0);
        }

        private int findMinDistanceRec(int[][] workers, int[][] bikes, int assignedBikes, int workerId)
        {
            if (workerId == workers.length)
            {
                return 0;
            }
            if (cache[assignedBikes] != -1)
            {
                return cache[assignedBikes];
            }

            int smallestDistance = Integer.MAX_VALUE;
            for (int bikeid=0; bikeid<bikes.length; bikeid++)
            {
                if ((assignedBikes & (1 << bikeid)) != 0) // if bike is not available
                {
                    continue;
                }

                int newAssignedBikes = assignedBikes | (1 << bikeid); // set bike as assighed
                int distance = Math.abs(workers[workerId][0] - bikes[bikeid][0]) + Math.abs(workers[workerId][1] - bikes[bikeid][1]);

                smallestDistance = Math.min(
                    smallestDistance,
                    distance + findMinDistanceRec(workers, bikes, newAssignedBikes, workerId + 1));
            }

            cache[assignedBikes] = smallestDistance;
            System.out.printf("cache[%s] = %s\n", Integer.toBinaryString(assignedBikes), smallestDistance);
            return smallestDistance;
        }
}