class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        Set<Integer> memo = new HashSet<>();
        
        int targetIdx = nums.length-1;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= nums[0]; i++)
        {
            if (i == targetIdx) return true;

            queue.add(i);
            memo.add(i);
        }
        while (queue.size() > 0)
        {
            int currIdx = queue.poll();
            for (int i=1; i<=nums[currIdx]; i++)
            {
                if (currIdx + i == targetIdx) return true;

                if (!memo.contains(currIdx + i))
                {
                    memo.add(currIdx + i);
                    queue.add(currIdx + i);
                }
            }
        }

        return false;
    }
}