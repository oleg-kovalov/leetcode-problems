class Solution {
    public int countCells(char[][] grid, String pattern) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] diffver = new int[rows * cols + 1];
        int[] diffhor = new int[rows * cols + 1];


        StringBuilder strHor = new StringBuilder();
        for (int row=0; row < rows; row++)
        {
            strHor.append(grid[row]); 
        }

        List<Integer> horMatchStarts = kmp(strHor.toString(), pattern);
        for (int start: horMatchStarts)
        {
            diffhor[start] += 1;
            diffhor[start + pattern.length()] -= 1;
        }
        System.out.println(Arrays.toString(diffhor));


        StringBuilder strVer = new StringBuilder();
        for (int col=0; col < cols; col++)
        {
            for (int row=0; row < rows; row++)
            {
                strVer.append(grid[row][col]);
            }
        }

        List<Integer> verMatchStarts = kmp(strVer.toString(), pattern);
        for (int start: verMatchStarts)
        {
            diffver[start] += 1;
            diffver[start + pattern.length()] -= 1;
        }
        System.out.println(Arrays.toString(diffver));


        for (int i=1; i< diffver.length; i++)
        {
            diffver[i] += diffver[i-1];
            diffhor[i] += diffhor[i-1];
        }

        
        int count = 0;
        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                int idxhor = row * cols + col;
                int idxver = col * rows + row; 


                if (diffver[idxver] > 0 && diffhor[idxhor] > 0) count+= 1;
            }
        }

        return count;    
        
    }

    private List<Integer> kmp(String haystack, String needle)
    {
        List<Integer> result = new ArrayList<>(); // list of startings indices of matches
        int[] lps = new int[needle.length()];

        int prevLPS = 0;
        int i = 1;
        while (i < lps.length)
        {
            if (needle.charAt(i) == needle.charAt(prevLPS))
            {
                lps[i] = prevLPS + 1;
                prevLPS += 1;
                i += 1; 
            } else if (prevLPS == 0)
            {
                lps[i] = 0;
                i += 1;
            } else {
                prevLPS = lps[prevLPS - 1];    
            }
        }

        int h = 0;
        int n = 0;
        while (h < haystack.length())
        {
            if (haystack.charAt(h) == needle.charAt(n))
            {
                if (n == needle.length() - 1)
                {
                    result.add(h - needle.length() + 1);
                    h += 1;
                    n = lps[n];
                } else {
                    h += 1;
                    n += 1;
                }
            } else
            {
                if (n == 0)
                {
                    h += 1;
                } else {
                    n = lps[n - 1];
                }
            }
        }

        return result;
    }
}