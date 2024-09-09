class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurences = new HashMap<>();

        for (int elem: arr)
        {
            occurences.merge(elem, 1, Integer::sum);
        }

        Set<Integer> uniqueOccurences = new HashSet<>(occurences.values());

        return occurences.size() == uniqueOccurences.size();
    }
}