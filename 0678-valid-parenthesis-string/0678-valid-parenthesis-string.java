class Solution {
    public boolean checkValidString(String s) {
    
        return checkForwards(s) && checkBackwards(s);
        // return checkForwards(s);
        // return checkBackwards(s);
    }

    public boolean checkForwards(String s) {

        int open = 0;
        int bracketStart = -1;
        for (int i=0; i<s.length(); i++)
        {
            if (s.charAt(i) != '*') 
            {
                bracketStart = i;
                break;
            }
            open += 1;
        }

        int close = 0;
        int bracketEnd = -1;
        for (int i=s.length()-1; i>=0; i--)
        {
            if (s.charAt(i) != '*') {
                bracketEnd = i;
                break;
            }
            close += 1;
        }

        int openClose = 0;

        if (bracketStart == -1) return true;

        int balance = 0; // open +, close -
        for (int i=bracketStart; i<bracketEnd + 1; i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                balance += 1;
            } else if (c == ')')
            {
                balance -= 1;
                if (balance < 0) {
                    if (open > 0) {
                        open -= 1;
                        balance += 1;
                    }
                    else if (openClose > 0) 
                    {
                        openClose -= 1;
                        balance += 1;
                    }
                    else return false;
                }
            } else {
                openClose += 1;
            }
        }

        return balance <= close + openClose; 

    }

    public boolean checkBackwards(String s) {

        int open = 0;
        int bracketStart = -1;
        for (int i=0; i<s.length(); i++)
        {
            if (s.charAt(i) != '*') 
            {
                bracketStart = i;
                break;
            }
            open += 1;
        }

        int close = 0;
        int bracketEnd = -1;
        for (int i=s.length()-1; i>=0; i--)
        {
            if (s.charAt(i) != '*') {
                bracketEnd = i;
                break;
            }
            close += 1;
        }

        int openClose = 0;

        if (bracketEnd == -1) return true;

        int balance = 0; // close +, open -
        for (int i=bracketEnd; i>=bracketStart; i--)
        {
            char c = s.charAt(i);
            if (c == ')')
            {
                balance += 1;
            } else if (c == '(')
            {
                balance -= 1;
                if (balance < 0) {
                    if (close > 0) {
                        close -= 1;
                        balance += 1;
                    }
                    else if (openClose > 0) 
                    {
                        openClose -= 1;
                        balance += 1;
                    }
                    else return false;
                }
            } else {
                openClose += 1;
            }
        }

        return balance <= open + openClose; 

    }
}