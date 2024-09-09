class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] numOfPeopleTrustMe = new int[n];
        int[] numOfPeopleItrust = new int[n];

        for (int[] t : trust)
        {            
            numOfPeopleItrust[t[0]-1]++;
            numOfPeopleTrustMe[t[1]-1]++;
        }

        for (int i=0; i<numOfPeopleTrustMe.length; i++)
        {
            if (numOfPeopleTrustMe[i] == n-1)
            {
                if (numOfPeopleItrust[i] == 0)
                {
                    return i+1;
                }
            }
        }

        return -1;
    }
}