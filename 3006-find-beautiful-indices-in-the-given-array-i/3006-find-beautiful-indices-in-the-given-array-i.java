class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        Set<Integer> indicesA = new HashSet<>();
        Set<Integer> indicesB = new HashSet<>();

        int fromIndex = 0;
        while (fromIndex <= s.length())
        {
            int indexA = s.indexOf(a, fromIndex);
            if (indexA == -1) break;

            indicesA.add(indexA);
            fromIndex = indexA + 1;
        }

        fromIndex = 0;
        while (fromIndex <= s.length())
        {
            int indexB = s.indexOf(b, fromIndex);
            if (indexB == -1) break;

            indicesB.add(indexB);
            fromIndex = indexB + 1;
        }

        TreeSet<Integer> result = new TreeSet<>();
        for (Integer indexA : indicesA) {
            int start = Math.max(0, indexA - k);
            int end = Math.min(s.length()-1, indexA + k);
            for (int i=start; i<=end; i++)
            {
                if (indicesB.contains(i))
                {
                    result.add(indexA);
                    break;
                }
            }
        }

        return new ArrayList<>(result);
    }
}