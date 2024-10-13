class Solution {
    class ValueIndex {
        private int index;
        private int value;

        public ValueIndex(int index, int value) { this.index = index; this.value = value; }

        public int getIndex() { return index; }
        public int getValue() { return value; }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, Integer> curValues = new HashMap<>(); //list index -> value
        TreeMap<Integer, Integer> valuesSorted = new TreeMap<>(); // value -> count

        PriorityQueue<ValueIndex> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i=0; i<nums.size(); i++)
        {
            int curListValue = nums.get(i).get(0);
            curValues.put(i, curListValue);
            valuesSorted.put(curListValue, valuesSorted.getOrDefault(curListValue, 0) + 1);

            for (int j=1; j<nums.get(i).size(); j++)
            {
                minHeap.offer(new ValueIndex(i, nums.get(i).get(j)));
            }
        }

        int rangeStart = valuesSorted.firstKey();
        int rangeEnd = valuesSorted.lastKey();
        int minRange = Math.abs(rangeEnd - rangeStart);

        while (minHeap.size() > 0)
        {
            ValueIndex valueIndex = minHeap.poll();
            int listIndex = valueIndex.getIndex();
            int nextValue = valueIndex.getValue();

            int curValue = curValues.get(listIndex);
            valuesSorted.put(curValue, valuesSorted.get(curValue) - 1);
            if (valuesSorted.get(curValue) == 0) {
                valuesSorted.remove(curValue);
            }

            curValues.put(listIndex, nextValue);
            valuesSorted.put(nextValue, valuesSorted.getOrDefault(nextValue, 0) + 1);

            if (minRange > Math.abs(valuesSorted.lastKey() - valuesSorted.firstKey()))
            {
                rangeStart = valuesSorted.firstKey();
                rangeEnd = valuesSorted.lastKey();
                minRange = Math.abs(rangeEnd - rangeStart);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}