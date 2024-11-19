class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> duplicatesCount = new HashMap<>();
        HashSet<Integer> uniqueSet = new HashSet<>();

        long maxSum = 0L;
        long runningSum = 0L;
        for (int i=0; i<k; i++)
        {
            int num = nums[i];
            runningSum += num;
            if (!uniqueSet.contains(num))
            {
                uniqueSet.add(num);
            } else {
                duplicatesCount.put(num, duplicatesCount.getOrDefault(num, 0) + 1);
            }
        }

        if (duplicatesCount.size() == 0)
        {
            maxSum = Math.max(maxSum, runningSum);
        }

        for (int end=k; end < nums.length; end++)
        {
            int start = end - k + 1;
            int toRemove = nums[start-1];
            int toAdd = nums[end];
            runningSum = runningSum - toRemove + toAdd;
            // remove start-1
            if (duplicatesCount.containsKey(toRemove))
            {
                int count = duplicatesCount.get(toRemove);
                if (count == 1)
                {
                    duplicatesCount.remove(toRemove);
                } else {
                    duplicatesCount.put(toRemove, count -1);
                }
            } else {
                uniqueSet.remove(toRemove);
            }

            //add end
            if (!uniqueSet.contains(toAdd))
            {
                uniqueSet.add(toAdd);
            } else {
                duplicatesCount.put(toAdd, duplicatesCount.getOrDefault(toAdd, 0) + 1);
            }

            if (duplicatesCount.size() == 0)
            {
                maxSum = Math.max(maxSum, runningSum);
            }
        }

        return maxSum;
    }
}