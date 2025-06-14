class Solution {
    record Flight(int from, int to) {};
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>(); 
        HashMap<Flight, Integer> prices = new HashMap<>();
        for (int[] f: flights)
        {
            int from = f[0]; int to = f[1]; int price = f[2];

            adjMap.putIfAbsent(from, new ArrayList<>());
            adjMap.get(from).add(to);

            prices.put(new Flight(from, to), price);
        }
        System.out.println(adjMap);
        System.out.println(prices);


        // [city, price, stops]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for (int dest: adjMap.getOrDefault(src, Collections.emptyList()))
        {
            int price = prices.get(new Flight(src, dest));
            minHeap.offer(new int[] {dest, price, k});
        }

        int[][] memo = new int[n][k+1];
        for (int i=0; i<memo.length; i++)
        {
            for (int j=0; j<memo[0].length; j++)
            {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }   

        while (minHeap.size() > 0)
        {
            int[] entry = minHeap.poll();
            int city = entry[0]; int price = entry[1]; int remK = entry[2];
            // System.out.printf("we are in city=%s, price=%s, remK=%s \n", city, price, remK);

            if (memo[city][remK] <= price) continue; // we were here with better price
            memo[city][remK] = price;

            if (city == dst) return price;
            if (remK <= 0) continue;

            for (int dest: adjMap.getOrDefault(city, Collections.emptyList()))
            {
                int nextPrice = prices.get(new Flight(city, dest));
                minHeap.offer(new int[] {dest, price + nextPrice, remK - 1});
            }
        }

        return -1;


    }
}