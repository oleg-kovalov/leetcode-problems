class Solution {
    List<String> result = new ArrayList<>();
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> result = new ArrayList<>();

        // for each coma position
        for (int comma=2; comma<s.length(); comma++)
        {
                // System.out.println(comma);
            List<String> nums1 = new ArrayList<>();
            generate(s.substring(1,  comma), nums1);
                // System.out.println(nums1);
            List<String> nums2 = new ArrayList<>();
            generate(s.substring(comma, s.length() - 1), nums2);
                // System.out.println(nums2);

            for (String num1: nums1)
            {
                for (String num2: nums2)
                {
                    result.add(new StringBuilder()
                        .append("(")
                        .append(num1)
                        .append(", ")
                        .append(num2)
                        .append(")")
                        .toString());
                }
            }
        }

        return result;
    }

    private void generate(String str, List<String> numsList)
    {
        if (str.length() == 0) return;

        // no dot
        if (str.charAt(0) != '0' || str.length() == 1) numsList.add(str);

        // all valid positions for dot
        for (int dot=1; dot<str.length(); dot++)
        {
            String whole = str.substring(0, dot);
            if (whole.charAt(0) == '0' && whole.length() > 1) break; // 01.2 is invalid

            String decimal = str.substring(dot);
            if (decimal.charAt(decimal.length()-1) == '0') break; // 1.20 is invaid


            numsList.add(str.substring(0, dot) + "." + decimal);
        }
    }

}

