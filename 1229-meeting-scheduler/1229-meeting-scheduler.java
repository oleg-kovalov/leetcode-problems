class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration)
    {
        Arrays.sort(slots1, Comparator.comparing(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparing(a -> a[0]));

        int i1 = 0;
        int i2 = 0;
        while (i1 < slots1.length && i2 < slots2.length)
        {
            int start1 = slots1[i1][0];
            int end1 = slots1[i1][1];

            int start2 = slots2[i2][0];
            int end2 = slots2[i2][1];

            if (start2 < end1 || start1 < end2)
            {
                int commonStart = Math.max(start1, start2);
                int commonEnd = Math.min(end1, end2);
                if (commonEnd - commonStart >= duration)
                {
                    return List.of(commonStart, commonStart + duration);
                }
            }

            if (end1 < end2)
            {
                i1++;
            }
            else
            {
                i2++;
            }

        }

        return Collections.emptyList();
    }
}