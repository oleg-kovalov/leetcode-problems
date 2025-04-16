class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] freqT = new int['z' - 'A' + 1]; 
        for (int i=0; i<t.length(); i++)
        {
            freqT[t.charAt(i) - 'A'] += 1;
        }


        int left = 0;
        int size = 0;
        int[] freqS = new int['z' - 'A' + 1]; 

        while (size < s.length() && !validWindow(freqS, freqT))
        {
            freqS[s.charAt(size) - 'A'] += 1;
            size += 1;
        }

        if (!validWindow(freqS, freqT)) return "";

        int resultLeft = left;
        int resultSize = size;

        while (size >= t.length() && left + size - 1 < s.length())
        {
            while (size >= t.length() && validWindow(freqS, freqT)) 
            {
                resultLeft = left;
                resultSize = size;
                // System.out.println(left + " + " + size);
    
                freqS[s.charAt(left) - 'A'] -= 1;
                left += 1;
                size -= 1;
            }

            left += 1;
            if (left + size - 1 < s.length()) 
            {
                freqS[s.charAt(left - 1) - 'A'] -= 1;
                freqS[s.charAt(left + size - 1) - 'A'] += 1;
            }
        }

        return s.substring(resultLeft, resultLeft + resultSize);
    }

    private boolean validWindow(int[] freqS, int[] freqT)
    {
        for (int i=0; i<freqT.length; i++)
        {
            if (freqT[i] > freqS[i]) return false;
        }

        return true;
    }

}