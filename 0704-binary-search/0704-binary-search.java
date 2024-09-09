class Solution {
    public int search(int[] nums, int target) {

        return search(0, nums.length-1, nums, target);

    }
    private int search(int start, int end, int[] nums, int target)
    {
        // System.out.println("start " + start + " end " + end);
        if (end - start <= 1)
        {
            if (nums[start] == target)
            {
                return start;
            }
            else if (nums[end] == target)
            {
                return end;
            }
            else {
                return -1;
            }
        }

        int mid = (end + start) / 2;

        if (nums[mid] < target)
        {
            return search(mid, end, nums, target);
        }
        else if (nums[mid] > target)
        {
            return search(start, mid, nums, target);
        } else {
            return mid;
        }
    }
}