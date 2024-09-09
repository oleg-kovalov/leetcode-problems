class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Integer rangeStart = nums[0];
        Integer rangeEnd = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (i == nums.length - 1) {
                result.add(curr == rangeStart ? ""+curr : rangeStart+"->"+curr);
                break;
            }
            int next = nums[i + 1];
            if (curr + 1 != next) {
                result.add(curr == rangeStart ? ""+curr : rangeStart+"->"+curr);
                rangeStart = next;
            }
        }
        return result;
    }
}