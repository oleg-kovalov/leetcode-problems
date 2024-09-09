class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;

        int current = 0;
        while (current < colors.length)
        {
            if (isGroup(current, k, colors))
            {
                result = result + 1;
                current = current + 1;
                if (current >= colors.length) break;

                while (current < colors.length && nextColorDiff(current + k - 2, colors) )
                {
                    result = result + 1;
                    current++;
                }
                if (current >= colors.length) break;

            }
            else
            {
                current++;
            }
        }

        return result;
    }

    private int currentToId(int current, int[] colors)
    {
        return current % colors.length;
    }

    private boolean nextColorDiff(int current, int[] colors)
    {
        return colors[current % colors.length] != colors[(current+1) % colors.length];
    }


    private boolean isGroup(int start, int k, int[] colors)
    {
        int col = colors[start];
        int c = start + 1;
        while (c < start + k )
        {
            if (col == colors[c % colors.length]) return false;

            col = colors[c % colors.length];
            c++;
        }

        return true;
    }
}