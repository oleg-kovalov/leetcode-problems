class Solution {
    public String convertDateToBinary(String date)
    {
        return new StringBuilder(intToBinary(date.substring(0, 4)))
            .append("-").append(intToBinary(date.substring(5, 7)))
            .append("-").append(intToBinary(date.substring(8))).toString();
    }

    private String intToBinary (String str)
    {
        return Integer.toBinaryString(Integer.valueOf(str));
    }
}