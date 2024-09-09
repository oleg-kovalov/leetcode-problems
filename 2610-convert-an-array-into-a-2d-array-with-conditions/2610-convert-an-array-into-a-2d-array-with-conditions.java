class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] counts = new int[nums.length+1];
        int maxCount = 0;

        for (int num : nums) {
            counts[num]++;
            maxCount = Math.max(maxCount, counts[num]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            result.add(new ArrayList<>());
        }

        for (int num=0; num<counts.length; num++) {
            for (int i=0; i<counts[num]; i++)
            {
                result.get(i).add(num);
            }
        }

        return result;
    }
}