class NumberContainers {

    Map<Integer, Integer> indexToNumber;
    Map<Integer, Set<Integer>> numberToIndex;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        Integer oldNumber = indexToNumber.put(index, number);
        if (oldNumber != null)
        {
            numberToIndex.get(oldNumber).remove(index);
            if (numberToIndex.get(oldNumber).isEmpty()) {
                numberToIndex.remove(oldNumber);
            }
        }

        numberToIndex.putIfAbsent(number, new TreeSet<>());
        numberToIndex.get(number).add(index);

    }
    
    public int find(int number) {
        return numberToIndex.containsKey(number) ? numberToIndex.get(number).iterator().next() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */