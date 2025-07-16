class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        int numGroups = hand.length / groupSize;

        Arrays.sort(hand);
        
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> group0 = new ArrayList<>();
        group0.add(hand[0]);
        groups.add(group0);

        for (int i=1; i<hand.length; i++)
        {
            int num = hand[i];
            boolean added = false;
            for (List<Integer> group: groups)
            {
                if (group.size() < groupSize && group.get(group.size() - 1) == num -1)
                {
                    group.add(num);
                    added = true;
                    break;
                }
            }

            if (added) continue;

            if (groups.size() < numGroups)
            {
                List<Integer> newGroup = new ArrayList<>();
                newGroup.add(num);
                groups.add(newGroup);
            } else {
                return false;
            }
        }

        // if (groups.size() != groupSize) return false;
        // for (List<Integer> group: groups)
        // {
        //     if (group.size() != groupSize) return false;
        // }

        return true;
    }
}