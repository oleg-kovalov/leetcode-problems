class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        for (int num: nums)
        {
            maxHeap.offer(num);
        }

        long score = 0;
        for (int i=0; i<k; i++)
        {
            int num = maxHeap.poll();
            score += num;
            // maxHeap.offer( num / 3 + (num % 3 == 0 ? 0 : 1));
            maxHeap.offer((int) Math.ceil((double)num / 3));
        }

        return score;
    }

}