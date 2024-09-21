class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int highDig = 1; highDig < 10; highDig++)
        {
            queue.offer(highDig);

            while (queue.peek() <= n)
            {
                int curr = queue.poll();
                result.add(curr);
                for (int i=0; i < 10; i++)
                {
                    queue.offer(curr * 10 + i);
                }
            }
            queue.clear();
        }

        return result;
    }
}