class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();
        int targetIdx = 0;
        int inputVal = 1;
        while (inputVal <= n && targetIdx < target.length)
        {
            if (inputVal == target[targetIdx])
            {
               result.add("Push");
               targetIdx++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
            inputVal++;
        }

        return result;

    }
}