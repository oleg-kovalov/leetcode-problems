class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;

        int backspaceI = 0;
        int backspaceJ = 0;

        while (i >=0 || j >=0)
        {
            if (i >=0 && '#' - s.charAt(i) == 0)
            {
                backspaceI++;
                i--;
                continue;
            }
            if (j >=0 && '#' - t.charAt(j) == 0)
            {
                backspaceJ++;
                j--;
                continue;
            }

            if (i >=0 && backspaceI > 0)
            {
                i--;
                backspaceI--;
                continue;
            }
            if (j>=0 && backspaceJ > 0)
            {
                j--;
                backspaceJ--;
                continue;
            }

            if (i>=0 && j>=0 && s.charAt(i) != t.charAt(j))
            {
                return false;
            }

            i--;
            j--;
        }

//        System.out.printf("i=%s, j=%s ", i, j);
        return  i == -1 && j == -1;
    }
}