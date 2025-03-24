class Solution {      
    public boolean canChange(String start, String target)  // _L__R__R_    L______RR
    {
        final char EMPTY = '_';
        final char L = 'L';
        final char R = 'R';
        int len = start.length();

        int i2 = 0; //8
        for (int i=0; i < len; i++) //7
        {
            char c = start.charAt(i); //R
            if (c == EMPTY) continue;
            
            while (i2 < len && target.charAt(i2) == EMPTY)
            {
                i2 += 1;
            }
            if (i2 == len) return false;
            char c2 = target.charAt(i2); //R

            if (c == L)
            {
                if (c2 == R || i < i2) return false;
            }
            else {
                if (c2 == L || i > i2) return false;
            }

            i2++;
           
        }

        for (int i=i2; i < len; i++)
        {
            if (target.charAt(i) != EMPTY) return false;
        }

        return true;
    }
}
