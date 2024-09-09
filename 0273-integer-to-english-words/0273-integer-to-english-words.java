import java.util.StringJoiner;


class Solution {
    private String[] digits = new String[] {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private String[] tens = new String[] {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private String[] thousands = new String[] {
        "", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringJoiner joiner = new StringJoiner(" ");

        for (int i=3; i > 0; i--)
        {
            int thousandsMlpr = num / (int)Math.pow(1000, i);
            if (thousandsMlpr != 0)
            {
                convert100s(thousandsMlpr, joiner);
                joiner.add(thousands[i]);
            }

            num = num % (int)Math.pow(1000, i);
        }

        convert100s(num, joiner);

        return joiner.toString();
    }

    private void convert100s(int num, StringJoiner joiner)
    {
        int hundred = num / 100;
        if (hundred != 0)
        {
            joiner.add(digits[hundred]).add("Hundred");
        }

        convert10s(num % 100, joiner);

    }

    private void convert10s(int num, StringJoiner joiner)
    {
        if (num == 0)
        {
            return;
        }

        if (num < 20)
        {
            joiner.add(digits[num]);
        }
        else {
            int ten = num / 10;
            joiner.add(tens[ten]);

            int digit = num % 10;
            if (digit != 0)
            {
                joiner.add(digits[digit]);
            }    
        }
    }
}