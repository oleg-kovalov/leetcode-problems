class Solution {
    
    class CharCount {
        final char ch;
        final int count;

        public CharCount(char ch, int count)
        {
            this.ch = ch; this.count = count;
        }

        public char getChar () { return ch; }
        public int getCount() { return count; }

    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((a1, a2) -> a2.getCount() - a1.getCount());
        if (a > 0 ) maxHeap.offer(new CharCount('a', a));
        if (b > 0 ) maxHeap.offer(new CharCount('b', b));
        if (c > 0 ) maxHeap.offer(new CharCount('c', c));

        StringBuilder result = new StringBuilder();
        
        while (maxHeap.size() > 1)
        {
            CharCount poll = maxHeap.poll();
            CharCount poll2 = maxHeap.poll();
            if (poll.getCount() - poll2.getCount() > 1)
            {
                result.append(poll.getChar()).append(poll.getChar());
                poll = new CharCount(poll.getChar(), poll.getCount() - 2);
            } else {
                result.append(poll.getChar());
                poll = new CharCount(poll.getChar(), poll.getCount() - 1);
            }

            result.append(poll2.getChar());
            poll2 = new CharCount(poll2.getChar(), poll2.getCount() - 1);

            if (poll2.getCount() > 0)
            {
                maxHeap.offer(poll2);
            }
            if (poll.getCount() > 0)
            {
                maxHeap.offer(poll);
            }
        }

        if (maxHeap.size() == 1)
        {
            CharCount poll = maxHeap.poll();
            if (poll.getCount() > 1)
            {
                result.append(poll.getChar()).append(poll.getChar());
            } else {
                result.append(poll.getChar());
            }
        }


        return result.toString();
    }
}