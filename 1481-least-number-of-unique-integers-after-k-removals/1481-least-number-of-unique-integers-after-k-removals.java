class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> countsMap = new HashMap<>();

        for (int i=0; i<arr.length; i++)
        {
            countsMap.put(arr[i], countsMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(countsMap.values());
        Collections.sort(counts);

        for (int v = 0; v < counts.size(); v++) {
            if (k >= counts.get(v))
            {
                k -= counts.get(v);
            }
            else {
                return counts.size() - v;
            }
        }

        return 0;
    }
}