class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) return s;

        char prevPrev = '_';   
        char prev = '_';
        StringBuilder result = new StringBuilder();
        
        for (int i=0; i<s.length(); i++)
        {
            char curr = s.charAt(i);
            if (curr - prev == 0 && curr - prevPrev == 0)
            {
                // skip
            } else {
                result.append(curr);
            }

            prevPrev = prev;
            prev = curr; 
        }

        return result.toString();  
    }
}