class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++)
        {
            if (arr[i] == 0)
            {
                if (i < arr.length - 1 && arr[i+1] == 0)
                {
                    return true;
                } else {
                    continue;
                }
            }
            int target = arr[i] * 2;
            int lo = 0;
            int hi = arr.length - 1;
            while ( lo <= hi)
            {
                int mid = (lo + hi) / 2;

                if (arr[mid] == target) {
                    return true;
                } else if (arr[mid] < target)
                {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }
}