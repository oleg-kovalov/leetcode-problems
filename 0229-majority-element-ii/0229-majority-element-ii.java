class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Set<Integer> result = new HashSet<>();
        int threshold = nums.length / 3;
        var seenCount = new HashMap<Integer, Integer>();

        for (int num : nums) {
            Integer count = seenCount.getOrDefault(num, 0);
            seenCount.put(num, count + 1);
            if (threshold < count + 1)
            {
                result.add(num);
            }
        }

        return new ArrayList<>(result);
    }
}