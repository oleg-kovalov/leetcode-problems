class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashMap<Integer, Boolean> visited = new HashMap<>();

        for (int num: nums)
        {
            visited.put(num, false);
        }    

        int maxCount = 0;
        
        for (int num: nums)
        {
            if (visited.get(num)) continue;

            int count = 1;
            visited.put(num, true);

            int curr = num - 1;
            while (visited.containsKey(curr) && !visited.get(curr))
            {
                count += 1;
                visited.put(curr, true);
                curr -= 1;
            }

            curr = num + 1;
            while (visited.containsKey(curr) && !visited.get(curr))
            {
                count += 1;
                visited.put(curr, true);
                curr += 1;
            }

            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}