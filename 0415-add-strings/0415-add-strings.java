class Solution {
    public String addStrings(String num1, String num2) {

        StringBuilder num1r = new StringBuilder(num1).reverse();
        StringBuilder num2r = new StringBuilder(num2).reverse();

        StringBuilder resBuilder = new StringBuilder();
        int carryOver = 0;

        int largerStrLength = Math.max(num1.length(), num2.length());
        for (int i=0; i< largerStrLength; i++)
        {
            int c1 = i < num1r.length() ? Integer.valueOf(String.valueOf(num1r.charAt(i))) : 0;
            int c2 = i < num2r.length() ? Integer.valueOf(String.valueOf(num2r.charAt(i))) : 0;

            resBuilder.append((carryOver + c1 + c2) % 10);
            carryOver = (carryOver + c1 + c2) / 10;

        }

        if (carryOver > 0) {
            resBuilder.append(carryOver);
        }

        return resBuilder.reverse().toString();
    }
}