class Solution {
    public String addSpaces(String s, int[] spaces) {

        int spaceIdx  = 0;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++)
        {
            if (spaceIdx < spaces.length && i == spaces[spaceIdx])
            {
                sb.append(' ');
                spaceIdx += 1;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }
}