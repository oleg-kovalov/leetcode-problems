class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Map<Integer,Integer> mbpp = new HashMap<>(); //maxBeautyPerPrice
        for (int[] item: items)
        {
            mbpp.put(item[0], Math.max(item[1], mbpp.getOrDefault(item[0], 0)));
        }

        List<int[]> maxBeauty = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: mbpp.entrySet())
        {
            maxBeauty.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(maxBeauty, (a, b) -> a[0] - b[0]);

        for (int i=1; i<maxBeauty.size(); i++)
        {
            int[] pair = maxBeauty.get(i);
            int price = pair[0];
            int beauty = pair[1];
            int prevBeauty = maxBeauty.get(i-1)[1];

            maxBeauty.set(i, new int[]{price, Math.max(beauty, prevBeauty)});
        }

        int[] result = new int[queries.length];

        for (int i=0; i<queries.length; i++)
        {
            int target = queries[i];

            int lo = 0;
            int hi = maxBeauty.size()-1;
            boolean found = false;
            while (lo < hi)
            {
                int mid = (lo + hi) / 2;
                int midPrice = maxBeauty.get(mid)[0];

                if (midPrice == target)
                {
                    result[i] = maxBeauty.get(mid)[1];
                    found = true;
                    break;
                }
                else if (midPrice > target)
                {
                    hi = mid-1;
                } else {
                    lo = mid + 1;
                }
            }

            if (!found) {
                if (target >= maxBeauty.get(lo)[0])
                {
                    result[i] = maxBeauty.get(lo)[1];
                } else {
                    if (lo > 0)
                    {
                        result[i] = maxBeauty.get(lo-1)[1];
                    } else {
                        result[i] = 0;
                    }
                }
            }


        }


        return result;

    }
}