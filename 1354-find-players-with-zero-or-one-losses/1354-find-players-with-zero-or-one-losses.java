class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses  = new HashMap<>();

        for (int[] match : matches) {
            losses.merge(match[0], 0, Integer::sum);
            losses.merge(match[1], 1, Integer::sum);
        }

        List<Integer> noLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (Map.Entry<Integer, Integer> lossEntry : losses.entrySet()) {
            if (lossEntry.getValue() == 0)
            {
                noLosses.add(lossEntry.getKey());
            } else if (lossEntry.getValue() == 1)
            {
                oneLoss.add(lossEntry.getKey());
            }
        }

        Collections.sort(noLosses);
        Collections.sort(oneLoss);

        return List.of(noLosses, oneLoss);
    }
}