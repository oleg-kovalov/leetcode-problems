class Solution {
    public int maxDistance(List<List<Integer>> arrays)
    {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int distance = 0;

        for (int i = 1; i < arrays.size(); i++)
        {
            int minCandidate = arrays.get(i).get(0);
            int maxCandidate = arrays.get(i).get(arrays.get(i).size()-1);

            distance = Math.max(distance,Math.max(Math.abs(max - minCandidate), Math.abs(maxCandidate - min)));
            min = Math.min(min, minCandidate);
            max = Math.max(max, maxCandidate);
        }

        return distance;

    }
}