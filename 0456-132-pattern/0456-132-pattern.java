class Solution 
{
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        HashMap<Integer, Integer> leftMinForPosition = new HashMap<>();
        int leftMin = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current < leftMin) {
                leftMin = current;
            }

            leftMinForPosition.put(i, leftMin);
        }

        LinkedList<Integer> monotonicIncreasingStack = new LinkedList<>();
        if (nums[nums.length - 1] > leftMinForPosition.get(nums.length - 1)) {
            monotonicIncreasingStack.push(nums[nums.length - 1]);
        }

        for (int i = nums.length - 2; i > 0; i--) {
            int current = nums[i];
            int left = leftMinForPosition.get(i);

            if (monotonicIncreasingStack.size() > 0 && monotonicIncreasingStack.peek() <= left)
            {
                // we need to discard values that are less or equal '1' in 132 pattern
                while (monotonicIncreasingStack.size() > 0 )
                {
                    if (monotonicIncreasingStack.peek() <= left)
                    {
                        monotonicIncreasingStack.pop();
                    }
                    else {
                        break;
                    }
                }
            }

            if (monotonicIncreasingStack.size() > 0)
            {
                int stackHead = monotonicIncreasingStack.peek();
                if (left < stackHead && stackHead < current)
                {
                    return true;
                }
            }

            monotonicIncreasingStack.push(current);

        }

        return false;
    }
}