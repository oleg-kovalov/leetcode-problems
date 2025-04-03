class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i=0; i<position.length; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        LinkedList<Double> stack = new LinkedList<>(); // non-decreasing
        stack.push((target - cars[0][0])/((double)cars[0][1]));

        for (int i=1; i<cars.length; i++)
        {
            double time = (target - cars[i][0]) / ((double) cars[i][1]);
            if (time > stack.peek())
            {
                stack.push(time);
            }
        }

        return stack.size();

    }
}