class Solution {
    public int shareCandies(int[] candies, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i=k; i < candies.length; i++)
        {
            counts.put(candies[i], counts.getOrDefault(candies[i], 0) + 1);
        }
        int flavors = counts.keySet().size();

        for (int i=1; i< candies.length -  k + 1; i++)
        {
            // add start - 1
            counts.put(candies[i-1], counts.getOrDefault(candies[i-1], 0) + 1);

            // remove end
            int end = counts.get(candies[i + k - 1]);
            if (end > 1)
            {
                counts.put(candies[i + k - 1], end - 1);
            } else {
                counts.remove(candies[i + k - 1]);
            }

            flavors = Math.max(flavors, counts.keySet().size());
        }

        return flavors;
    }
}