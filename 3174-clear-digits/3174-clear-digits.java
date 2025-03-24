class Solution {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();

        int remove = 0;
        for (int i=s.length()-1; i>=0; i--)
        {
            char curr = s.charAt(i);
            if (Character.isDigit(curr))
            {
                remove++;
            } else {
                if (remove > 0)
                {
                    remove--;
                } else {
                    result.append(curr);
                }
            }
        }

        return result.reverse().toString();

    }
}