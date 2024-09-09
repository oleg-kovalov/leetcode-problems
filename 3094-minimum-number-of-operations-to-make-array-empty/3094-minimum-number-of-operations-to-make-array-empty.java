class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            counts.merge(num ,1, Integer::sum);
        }

        for (Integer count : counts.values()) {
            if (count == 1) return -1;

            if (count >= 3)
            {
                if (count % 3 == 1)
                {
                    operations += (count-4) / 3;
                    count = 4;
                } else {
                    operations += count / 3;
                    count = count % 3;
                }
            }

            if (count >= 2)
                operations += count / 2;
        }

        return operations;
    }
}