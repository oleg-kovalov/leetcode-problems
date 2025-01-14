class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> seen = new HashSet<>();
        int[] result = new int[A.length];

        for (int i=0; i<result.length; i++)
        {
            result[i] = (i == 0 ? 0 : result[i-1]);
            if (seen.contains(A[i]))
            { 
                result[i] += 1;
            } else {
                seen.add(A[i]);
            }

            if (seen.contains(B[i]))
            {
                result[i] += 1;
            } else {
                seen.add(B[i]);
            }
        }

        return result;
    }
}