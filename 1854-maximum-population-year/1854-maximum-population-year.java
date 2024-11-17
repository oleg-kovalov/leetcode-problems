class Solution {
        public int maximumPopulation(int[][] logs)
        {
            // line sweep
            int[] prefix = new int[101];
            for (int[] log: logs)
            {
                prefix[log[0] - 1950] += 1;
                prefix[log[1] - 1950] -= 1;
            }

            for (int i=1; i<prefix.length; i++)
            {
                prefix[i] += prefix[i - 1];
            }

            int max = 0;
            int firstMaxYear = 0;
            for (int i=0; i < prefix.length; i++)
            {
                if (max < prefix[i])
                {
                    max = prefix[i];
                    firstMaxYear = i + 1950;
                }
            }

            return firstMaxYear;
        }
}