class Solution {

    Map<Character, Integer> freq;
    int result = 0;
    
    public int numTilePossibilities(String tiles) {
        freq = new HashMap<>();
        for (int i=0; i<tiles.length(); i++) 
        {
            char c = tiles.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

            
        rec();

        return result;
    }

    private void rec ()
    {
        for (char c : freq.keySet())
        {
            int oldFreq = freq.get(c);
            if (oldFreq < 1) continue;

            freq.put(c, oldFreq - 1);
            result += 1;
            rec();
        
            freq.put(c, oldFreq);
        }
    }   
}