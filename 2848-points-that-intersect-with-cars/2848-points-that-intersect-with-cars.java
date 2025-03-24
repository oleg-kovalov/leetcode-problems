class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        
        int maxCoord = -1;
        for (List<Integer> car : nums)
        {
            maxCoord = Math.max(maxCoord, car.get(1));
        }

        int[] linesweep = new int[maxCoord + 2];
        for (List<Integer> car : nums)
        {
            linesweep[car.get(0)] += 1;
            linesweep[car.get(1) + 1] -= 1;
        }

        int result = linesweep[0] > 0 ? 1 : 0;
        for (int i=1; i<linesweep.length; i++)
        {
            linesweep[i] += linesweep[i-1];
            result += (linesweep[i] > 0 ? 1 : 0);
        }

        return result;

    }
}