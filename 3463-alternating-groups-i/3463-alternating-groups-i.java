class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int result = 0;
        for (int i=0; i<colors.length-2; i++)
        {
            if ((colors[i] != colors[i+1]) && (colors[i] == colors[i+2]))
            {
                result +=1;
            }
        }
        if ((colors[colors.length-2] != colors[colors.length-1]) && 
            (colors[colors.length-2] == colors[0]))
            result += 1;

        if ((colors[colors.length-1] != colors[0]) &&
            (colors[colors.length-1] == colors[1]))
            result += 1;
        
        return result;

    }
}