class Solution {
    public boolean canChange(String start, String target) {
        
        int startIdx = 0;
        for (int i=0; i<target.length(); i++)
        {
            char targetChar = target.charAt(i);
            if (targetChar == '_' ) 
            {
                continue;
            }
            else if (targetChar == 'L')
            {
                while (startIdx < start.length() && start.charAt(startIdx) == '_')
                {
                    startIdx += 1;
                }
                if (startIdx == start.length()) return false;
                if (start.charAt(startIdx) != 'L') return false;
                if (startIdx < i) return false;
                startIdx += 1;
            }
            else {
                while (startIdx < start.length() && start.charAt(startIdx) == '_')
                {
                    startIdx += 1;
                }
                if (startIdx == start.length()) return false;
                if (start.charAt(startIdx) != 'R') return false;
                if (startIdx > i) return false;
                startIdx += 1;
            }
        }

        for (int i=startIdx; i<start.length(); i++)
        {
            if (start.charAt(i) != '_') return false;
        }

        return true;

    }
}