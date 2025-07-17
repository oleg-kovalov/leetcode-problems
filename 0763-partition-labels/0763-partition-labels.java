class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] starts = new int[26];
        Arrays.fill(starts, -1);

        int[] ends = new int[26];
        Arrays.fill(ends, -1);

        for (int i=0; i<s.length(); i++)
        {
            int c = s.charAt(i) - 'a';

            if (starts[c] == -1) starts[c] = i;
            ends[c] = i;
        }


        List<Integer> result = new ArrayList<>();

        int offset = -1;
        int partitionEnd = -1;
        for (int i=0; i<s.length(); i++)
        {
            int letter = s.charAt(i) - 'a';
            int start = starts[letter];

            if (partitionEnd != -1 && start > partitionEnd)
            {
                result.add(partitionEnd - offset);
                offset += (partitionEnd - offset);
            }
            int end = ends[letter];
            partitionEnd = Math.max(partitionEnd, end);
        }


        result.add(partitionEnd - offset);

        return result;
    }
}