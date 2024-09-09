class Solution {
    private Map<Integer, List<Road>> fromToRoad = new HashMap<>();
    private Set<Integer> visitedCities = new HashSet<>();
    private int shortestRoad = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        for (int[] road : roads) {
            List<Road> roadsList = fromToRoad.containsKey(road[0])
                ? fromToRoad.get(road[0])
                : new ArrayList<>();
            roadsList.add(new Road(road[0], road[1], road[2]));
            fromToRoad.put(road[0], roadsList);

            List<Road> reverseRoadsList = fromToRoad.containsKey(road[1])
                    ? fromToRoad.get(road[1])
                    : new ArrayList<>();
            reverseRoadsList.add(new Road(road[1], road[0], road[2]));
            fromToRoad.put(road[1], reverseRoadsList);
        }

        traverse( 1);

        return shortestRoad;
    }

    private void traverse(int current)
    {
        List<Road> roads = fromToRoad.get(current);
        visitedCities.add(current);
        for (Road road : roads) {
            shortestRoad = Math.min(shortestRoad, road.distance);
            if (visitedCities.contains(road.to))
            {
                continue;
            }
            System.out.println("at " + current);
            traverse(road.to);
        }
    }

    private class Road
    {
        private final int from, to, distance;

        public Road(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }
    }
}