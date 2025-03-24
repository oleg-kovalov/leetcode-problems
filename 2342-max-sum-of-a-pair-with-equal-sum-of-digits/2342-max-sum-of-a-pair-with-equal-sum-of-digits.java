class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> sumToInts = new HashMap<>();

        int result = -1;

        for (int num: nums)
        {
            int sum = 0;
            int decrNum = num;
            while (decrNum >= 10)
            {
                sum += (decrNum % 10);
                decrNum /= 10;
            }
            sum += decrNum;

            Integer currMax = sumToInts.get(sum);
            if (currMax != null)
            {
                result = Math.max(result, currMax + num);
                if (num > currMax) {
                    sumToInts.put(sum, num);
                }
            } else {
                sumToInts.put(sum, num);
            }

        }


        return result;
    }
}