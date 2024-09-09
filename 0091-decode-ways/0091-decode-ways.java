class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {

        return numDecodingsRec(0, s);
    }

    private int numDecodingsRec(int index, String s)
    {
        if (cache.containsKey(index))
        {
            return cache.get(index);
        }

        if (index == s.length())
        {
            return 1;
        }

        if (s.charAt(index) == '0')
        {
            return 0;
        }

        if (index == s.length() - 1)
        {
            return 1;
        }


        int count = numDecodingsRec(index + 1, s);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26)
        {
            count += numDecodingsRec(index+2, s);
        }

        cache.put(index, count);

        return count;
    }
}