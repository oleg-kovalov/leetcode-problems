class Solution {
    public int[] resultsArray(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<k; i++)
        {
            addLast(deque, nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = (deque.size() == k) ? deque.peekLast() : -1;

        for (int i=1; i<result.length; i++)
        {
            if (deque.size() == k) {
                deque.removeFirst();
            }
            
            addLast(deque, nums[i + k - 1]);
            result[i] = (deque.size() == k) ? deque.peekLast() : -1;
        }

        return result;

    }

    private void addLast(Deque<Integer> deque, int num)
    {
        if (deque.peekLast() != null && deque.peekLast() != num - 1)
        {
            deque.clear();
        }

        deque.addLast(num);
    }
}