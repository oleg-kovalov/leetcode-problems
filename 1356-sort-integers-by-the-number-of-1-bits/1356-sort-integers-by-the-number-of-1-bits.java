class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArray, (n1, n2) -> {
            int count1 = Integer.bitCount(n1);
            int count2 = Integer.bitCount(n2);
            return count1 == count2 ? n1 - n2 : count1 - count2;
        });
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }
}