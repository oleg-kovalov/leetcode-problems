class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put("I", 1);
        romanToInteger.put("IV", 4);
        romanToInteger.put("V", 5);
        romanToInteger.put("IX", 9);
        romanToInteger.put("X", 10);
        romanToInteger.put("XL", 40);
        romanToInteger.put("L", 50);
        romanToInteger.put("XC", 90);
        romanToInteger.put("C", 100);
        romanToInteger.put("CD", 400);
        romanToInteger.put("D", 500);
        romanToInteger.put("CM", 900);
        romanToInteger.put("M", 1000);

        int result = 0;


        for (int i= 0; i < s.length();)
        {
            String current = String.valueOf(s.charAt(i));
            String next = s.length() > i+1 ? String.valueOf(s.charAt(i+1)) : "Z";
            if (romanToInteger.containsKey(current + next))
            {
                result = result + romanToInteger.get(current + next);
                i = i + 2;
            }
            else
            {
                result = result + romanToInteger.get(current);
                i = i + 1;
            }
        }

        return result;
    }
}