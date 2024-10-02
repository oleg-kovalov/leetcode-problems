class Solution {
    class IdxVal {
        int idx;
        int val;

        IdxVal(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int getVal() { return val; }

        public int getIdx() { return idx; }
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        PriorityQueue<IdxVal> minHeap = new PriorityQueue<>(Comparator.comparing(IdxVal::getVal));
        for (int i=0; i<arr.length; i++)
        {
            minHeap.offer(new IdxVal(i, arr[i]));
        }


        int[] result = new int[arr.length];
        int rank = 1;
        IdxVal curr = minHeap.poll();
        result[curr.getIdx()] = rank;
        IdxVal prev = curr;
        
        while (minHeap.size() > 0)
        {
            curr = minHeap.poll();
            if (curr.getVal() > prev.getVal()) rank += 1;

            result[curr.getIdx()] = rank;
            prev = curr;
        }

        return result;
    }
}