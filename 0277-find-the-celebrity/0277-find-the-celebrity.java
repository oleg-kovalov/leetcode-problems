/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        int candidate = findCandidate(n);
        if (candidate == -1 ) return -1;
        boolean allKnowsCandidate = true;
        for (int i=0; i<n; i++)
        {
            if (!knows(i, candidate))
            {
                allKnowsCandidate = false;
                break;
            }
        }
        if (allKnowsCandidate) return candidate;

        return -1;
    }

    private int findCandidate( int n)
    {
        int candidate = 0;
        for (int i=0; i < n; i++)
        {
            if (knows(candidate, i))
            {
                candidate = i;
            }
        }

        
        //TODO : validate candidate
        for (int i=0; i<n; i++)
        {
            if (i == candidate) continue;
            if (!knows(i, candidate) || knows(candidate, i))
            {
                return -1;
            }
        }

        return candidate;
    }

}