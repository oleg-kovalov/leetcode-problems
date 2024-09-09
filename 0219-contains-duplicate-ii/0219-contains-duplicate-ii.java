class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k == 0 ) return false;

        int end = Math.min(k, nums.length-1);
        int start = 0;

        Set<Integer> seen = new HashSet<>();
        for (int idx = 0; idx <= end; idx++)
        {
            int current = nums[idx];
            if (seen.contains(current)) return true;
            seen.add(current);
        }

        end = end + 1;
        start = Math.max(end - k, 0);

        while (end < nums.length)
        {
            System.out.println("start " + start + " end " + end);
            seen.remove(nums[start-1]);
            int last = nums[end];
            if (seen.contains(last)) return true;
            seen.add(last);

            end = end + 1;
            start = Math.max(end - k, 0);
        }

        return false;
    }

}