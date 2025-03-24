class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) { 

        int result = 0;
        int sum = 0; 
        for (int i=0; i<k; i++)
        {
            sum += arr[i];
        }
        if (sum / k >= threshold) result += 1;

        for (int left=1; left + k - 1 < arr.length; left++)
        {
            sum -= arr[left-1];
            sum += arr[left + k - 1];
            if (sum / k >= threshold) result += 1; 
        }

        return result;

    }
}