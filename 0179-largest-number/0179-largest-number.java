class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> numsSorted = Arrays.stream(nums).boxed().sorted((a, b) -> {
            String strA = String.valueOf(a);
            String strB = String.valueOf(b);

            String ab = strA + strB;
            String ba = strB + strA;

            return ab.compareTo(ba);

        }).toList();

        StringBuilder result = new StringBuilder();
        //reversed to get DESC sorting
        for (int i=numsSorted.size()-1; i>=0; i--)
        {
            result.append(String.valueOf(numsSorted.get(i)));
        }

        return result.toString();

    }
}