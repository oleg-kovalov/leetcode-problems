class Solution {
    public int findPairs(int[] nums, int k) {
        
            // [2,2,4,5,6]   ,2
            // [1,1,3,4,5] , 2

            HashSet<String> set = new HashSet<>();
            Arrays.sort(nums);

            for (int i=0; i<nums.length; i++)
            {
                int num = nums[i];
                int lower = search(nums, i+1, nums.length -1, num - k);
                if (lower >= 0)
                {
                    set.add(nums[lower] + "-" + num);
                }

                int upper = search(nums, i+1, nums.length - 1, num + k);
                if (upper >= 0)
                {
                    set.add(num + "-" + nums[upper]);
                }
            }

            System.out.println(set);
            return set.size();

    }

    private int search(int[] nums, int lo, int hi, int target)
    {
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target)
            {
                lo = mid + 1;
            } else if (nums[mid] > target)
            {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}