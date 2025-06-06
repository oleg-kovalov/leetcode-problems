class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for (int i=0; i<nums.length; i++)
        {
            maxHeap.offer(new int[] {nums[i], i});
        }

        List<int[]> biggest = new ArrayList<>();
        for (int i=0; i<k; i++)
        {
            biggest.add(maxHeap.poll());
        }

        Collections.sort(biggest, (a,b) -> Integer.compare(a[1], b[1]));

        int[] result = new int[k];
        for (int i=0; i<k; i++)
        {
            result[i] = biggest.get(i)[0];
        }

        return result;
    }
}