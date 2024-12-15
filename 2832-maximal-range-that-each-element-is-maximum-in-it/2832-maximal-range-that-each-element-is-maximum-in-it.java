class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {

        LinkedList<Integer> minStack = new LinkedList<>();

        int[] rightB = new int[nums.length];
        for (int i=0; i<nums.length; i++)
        {
            while (minStack.size() != 0 && nums[minStack.peek()] < nums[i])
            {
                rightB[minStack.pop()] = i;
            }

            minStack.push(i);

        }
        while (minStack.size() > 0)
        {
            rightB[minStack.pop()] = nums.length;
        }

        int[] leftB = new int[nums.length];
        for (int i=nums.length - 1; i>=0; i--)
        {
            
            while (minStack.size() != 0 && nums[minStack.peek()] < nums[i])
            {
                leftB[minStack.pop()] = i + 1;
            }

            minStack.push(i);
        }
        while (minStack.size() > 0)
        {
            leftB[minStack.pop()] = 0;
        }

        System.out.println(Arrays.toString(rightB));
        System.out.println(Arrays.toString(leftB));

        int[] result = new int[nums.length];
        for (int i=0; i<result.length; i++)
        {
            result[i] = rightB[i] - leftB[i];
        }

        return result;
    }
}