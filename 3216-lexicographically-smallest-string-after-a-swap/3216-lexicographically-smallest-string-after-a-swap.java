class Solution {
    public String getSmallestString(String s) {

        StringBuilder result = new StringBuilder();

        int i=0;
        boolean swapped = false;
        while (i < s.length())
        {
            int curr = s.charAt(i) - '0';
            if (i == s.length() -1 ) 
            {
                result.append(curr);
                break;
            }
            int next = s.charAt(i+1) - '0';
            if (!swapped && curr % 2 == next % 2 && curr > next)
            {
                result.append(next);
                result.append(curr);
                swapped = true;
                i += 2;
            } else {
                result.append(curr);
                i += 1;
            }
            
        }


        return result.toString();
    }
}