class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] count = new int[2001];
        
        for (int num : arr1)
        {
            count[num] += 1;
        }
        for (int num: arr2)
        {
            count[num] += 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int num: arr3)
        {
            if (count[num] == 2) result.add(num);
        }

        return result;
    }
}