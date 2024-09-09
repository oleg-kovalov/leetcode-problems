class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int fullBottles = numBottles;
        int emptyBottles = 0;
        int count = 0;

        while (fullBottles > 0)
        {
            //drink
            count += fullBottles;
            emptyBottles = emptyBottles + fullBottles;

            //exchange
            fullBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return count;
    }
}