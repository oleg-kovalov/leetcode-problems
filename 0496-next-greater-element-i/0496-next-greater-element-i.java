class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        LinkedList<Integer> stack = new LinkedList<>(); //decreasing monotonic stack
        HashMap<Integer, Integer> elemToNextGreater = new HashMap<>();

        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++)
        {
            int num2 = nums2[i];
            while (stack.size() > 0 && stack.peek() < num2)
            {
                elemToNextGreater.put(stack.pop(), num2);
            }

            stack.push(num2);
        }

        while (stack.size() > 0)
        {
            elemToNextGreater.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++)
        {
            result[i] = elemToNextGreater.get(nums1[i]);
        }

        return result;
    }
}