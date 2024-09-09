class Solution {
    public int countHomogenous(String s) {
        if (s.length() == 1) return 1;

        long result = 0L;
        int repeatingCount = 0;
        char prev = s.charAt(0);

        for (int i=1; i<s.length(); i++) {
            char current = s.charAt(i);
            if (current == prev)
            {
                repeatingCount++;
            } else {
                if (repeatingCount == 0)
                {
                    result += 1;
                } else {
                    result += (long)(repeatingCount+1) * (repeatingCount +1 + 1) / 2;
                    repeatingCount = 0;
                }
            }
            prev = current;
        }

        result += (long)(repeatingCount+1) * (repeatingCount + 1 + 1) / 2;

        return (int)(result % 1_000_000_007);
    }
}