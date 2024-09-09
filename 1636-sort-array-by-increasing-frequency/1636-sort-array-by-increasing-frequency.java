class Solution {

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (final int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (v1, v2) -> {
            if (freqMap.get(v1).equals(freqMap.get(v2)))
                return Integer.compare(v2,v1);
            else
                return Integer.compare(freqMap.get(v1), freqMap.get(v2)); });

        return Arrays.stream(numsObj).mapToInt(Integer::intValue).toArray();
    }
}