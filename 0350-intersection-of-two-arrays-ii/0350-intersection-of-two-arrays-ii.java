class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        for (int n1: nums1)
        {
            count1[n1] += 1;
        }

        int[] countRes = new int[1001];
        for (int n2: nums2)
        {
            if (count1[n2] > 0) {
                countRes[n2] += 1;
                count1[n2] -= 1;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<countRes.length; i++) {
            for (int n=0; n<countRes[i]; n++)
            {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}