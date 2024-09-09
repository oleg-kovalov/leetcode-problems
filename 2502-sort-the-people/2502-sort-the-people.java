class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> nth = new TreeMap<>(Comparator.reverseOrder());
        for (int i=0; i<names.length; i++)
        {
            nth.put(heights[i], names[i]);
        }

        return nth.values().toArray(String[]::new);
    }
}