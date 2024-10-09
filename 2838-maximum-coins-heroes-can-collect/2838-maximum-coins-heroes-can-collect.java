class Solution {
    class MonsterCoin {

        final int monster;
        final int coin;

        public MonsterCoin(int monster, int coin)
        {
            this.monster = monster;
            this.coin = coin;
        }

        public int getMonster() { return monster; }

        public int getCoin() { return coin; }

    }

    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        PriorityQueue<MonsterCoin> minHeap = new PriorityQueue<>(Comparator.comparing(MonsterCoin::getMonster));
        for (int i=0; i < monsters.length; i++)
        {
            minHeap.offer(new MonsterCoin(monsters[i], coins[i]));
        }

        HashMap<Integer, Long> heroToCoin = new HashMap<>();
        
        long[] result = new long[heroes.length];
        for (int i=0; i<heroes.length; i++)
        {
            result[i] = heroes[i];
        }
        Arrays.sort(heroes);
        long prevCoins = 0;
        for (int i=0; i< heroes.length; i++)
        {
            long currCoins = 0;
            while (minHeap.peek() != null && minHeap.peek().getMonster() <= heroes[i]) {
                currCoins += minHeap.poll().getCoin();
            }
            heroToCoin.put(heroes[i], currCoins + prevCoins);
            prevCoins += currCoins;
        }

        for (int i=0; i < result.length; i++)
        {
            result[i] = heroToCoin.get((int)result[i]);
        }


        return result;
    }

}