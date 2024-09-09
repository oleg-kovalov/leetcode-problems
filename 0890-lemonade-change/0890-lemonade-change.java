class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int bill: bills)
        {
            if (bill == 5)
            {
                fives += 1;
            } else if (bill == 10)
            {
                if (fives < 1) return false;
                fives -= 1;
                tens += 1;
            } else if (bill == 20)
            {
                if ((tens > 0) && (fives > 0))
                {
                    fives -=1;
                    tens -=1;
                } else if (fives > 2)
                {
                    fives -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}