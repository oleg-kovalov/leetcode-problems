class Solution {

    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (int num: nums)
        {
            if (seen.contains(num)) continue;
            seen.add(num);

            double sqrtNum = Math.sqrt(num);
            while (sqrtNum % 1 == 0)
            {
                num = (int)sqrtNum;
                sqrtNum = Math.sqrt(num);
            }

            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int maxResult = 1;
        for (Map.Entry<Integer, Integer> entry: count.entrySet())
        {
            if (entry.getValue() > maxResult)
            {
                boolean valid = true;
                int num = entry.getKey();
                for (int i=1; i < entry.getValue(); i++)
                {
                    num = num * num;
                    if (!seen.contains(num)) {
                        valid = false;
                        break;
                    }    
                }
                if (valid) maxResult = entry.getValue();
            }
        }

        return maxResult > 1 ? maxResult : -1;
    }
}