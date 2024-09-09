class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counts = new int[1001];

        for (int i=0; i<arr.length; i++)
        {
            counts[arr[i]] += 1;
        }

        for (int i=0; i<target.length; i++)
        {
            counts[target[i]] -= 1;
        }

        for (int i=0; i<counts.length; i++)
        {
            if (counts[i] != 0) return false;
        }

        return true;
    }

}