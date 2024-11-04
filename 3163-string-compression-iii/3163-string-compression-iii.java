class Solution {
    public String compressedString(String word) {
        int count = 1;
        char prev = word.charAt(0);

        StringBuilder result = new StringBuilder();
        for (int i=1; i<word.length(); i++)
        {
            char curr = word.charAt(i);
            if (curr == prev)
            {
                if (count < 9)
                {
                    count += 1;
                }
                else {
                    result.append(count).append(prev);
                    count = 1;
                }
            }
            else {
                result.append(count).append(prev);
                count = 1;
            }
            prev = curr;
        }

        result.append(count).append(prev);

        return result.toString();  
    }
}