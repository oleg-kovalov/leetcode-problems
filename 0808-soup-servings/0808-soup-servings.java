class Solution {
    double[][] cache;

    public double soupServings(int n) {
        if (n > 4800) return 1.0;


        cache = new double[n + 1][n + 1];
        for (int i=0; i<n+1; i++)
        {
            Arrays.fill(cache[i], -1);
        }

        return dfs(n,n);

    }

    private double dfs(int soupA, int soupB)
    {
        if (cache[Math.max(0, soupA)][Math.max(0, soupB)] != -1) 
            return cache[Math.max(0, soupA)][Math.max(0, soupB)];
        
        if (soupA <= 0 && soupB <= 0) 
        {
            return 0.5;
        } 
        if (soupA <= 0)
        {
            return 1.0;
        }
        if (soupB <= 0)
        {
            return 0.0;
        }

        double result = 0;

        int[][] options = new int[][] {{-100, 0}, {-75, -25}, {-50,-50}, {-25,-75}};
        
        for (int[] option: options)
        {
            result += dfs(soupA + option[0], soupB + option[1]);

        }

        return cache[Math.max(0, soupA)][Math.max(0, soupB)] = 
            0.25 * result;
    }


}