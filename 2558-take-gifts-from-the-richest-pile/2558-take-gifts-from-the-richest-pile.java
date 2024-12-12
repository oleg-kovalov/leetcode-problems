class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
        for (int gift: gifts)
        {
            maxHeap.offer(gift);
        }                

        for (int i=0; i<k; i++)
        {
            int gift = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(gift));
        }

        long total = 0;
        while (maxHeap.size() > 0)
        {
            total += maxHeap.poll();
        }

        return total;
        
            
    }
}