class Solution {
    public int buyChoco(int[] prices, int money) {

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < secondMin)
            {
                if (price < min)
                {
                    secondMin = min;
                    min = price;
                } else {
                    secondMin = price;
                }
            }
        }

        int leftover = money - secondMin - min;

        return leftover >= 0 ? leftover : money;
    }
}