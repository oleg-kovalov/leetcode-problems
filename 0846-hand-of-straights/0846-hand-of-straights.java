class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freq = new TreeMap<>();
        for (int card: hand)
        {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        int groupNum = hand.length / groupSize;

        for (int group=0; group < groupNum; group++)
        {
            int curr = freq.keySet().iterator().next();
            if (freq.get(curr) == 1) 
            {
                freq.remove(curr);
            } else {
                freq.put(curr, freq.get(curr) - 1);
            }

            int target = curr + 1;
            for (int i=0; i<groupSize - 1; i++)
            {
                if (freq.containsKey(target))
                {
                    if (freq.get(target) == 1) 
                    {
                        freq.remove(target);
                    } else {
                        freq.put(target, freq.get(target) - 1);
                    }
                    target += 1;
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}