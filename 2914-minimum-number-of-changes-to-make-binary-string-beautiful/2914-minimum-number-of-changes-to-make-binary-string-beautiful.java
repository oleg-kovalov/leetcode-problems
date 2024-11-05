class Solution {
    public int minChanges(String s) {
        int changes = 0;
        char prev = s.charAt(0);
        int consecutive = 1;

        for (int i=1; i<s.length(); i++)
        {
            char curr = s.charAt(i);
            if (prev == curr)
            {
                consecutive += 1;
            } else {
                if (consecutive % 2 == 1)
                {                    
                    changes += 1;
                    consecutive += 1;
                } else {
                    prev = curr;
                    consecutive = 1;
                }
            }
        }

        return changes;
    }
}