class Solution {
    public int maximumLength(String s) {
        
        HashMap<Character, List<Integer>> substrings = new HashMap<>();

        int count = 1;
        char prev = s.charAt(0);
        for (int i=1; i< s.length(); i++)
        {
            char curr = s.charAt(i);
            if (curr == prev)
            {
                count += 1;
            } else {
                List<Integer> list = substrings.getOrDefault(prev, new ArrayList<>());
                list.add(count);
                substrings.put(prev, list);

                count = 1;
                prev = curr;
            }
        }

        List<Integer> list = substrings.getOrDefault(prev, new ArrayList<>());
        list.add(count);
        substrings.put(prev, list);

        int result = 0;
        for (Map.Entry<Character,List<Integer>> entry : substrings.entrySet())
        {
            int maxForChar = 0;
            List<Integer> lengthes = entry.getValue();
            Collections.sort(lengthes, (a,b) -> b - a);

            maxForChar = Math.max(maxForChar, lengthes.get(0) - 2);

            if (lengthes.size() >= 2)
            {
                maxForChar = Math.max(maxForChar, Math.min(lengthes.get(0) - 1, lengthes.get(1)));
            }

            if (lengthes.size() >= 3)
            {
                maxForChar = Math.max(maxForChar, lengthes.get(2));
            }

            result = Math.max(result, maxForChar);
        
        }

        return result == 0 ? -1 : result;
    }
}