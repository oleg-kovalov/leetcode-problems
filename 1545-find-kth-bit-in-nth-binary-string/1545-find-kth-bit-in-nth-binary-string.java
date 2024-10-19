class Solution {
    public char findKthBit(int n, int k) {
        Map<Integer, Boolean> known = new HashMap<Integer, Boolean>();

        int size = 1;
        known.put(1, false);

        while (size < k)
        {
            known.put(size + 1, true);
            size = size + size + 1;
        }

        boolean neg = false;
        int curr = k;
        while (!known.containsKey(curr)) {
            //find complementary element in left side of the range
            // [curr] = ![compl]
            int mid = size / 2 + 1;
            int leftPos = curr - mid;
            int rightPos = mid - leftPos;
            
            curr = rightPos;
            neg = !neg;
            size = (size - 1) /2;  
        }

        boolean result = neg ? !known.get(curr) : known.get(curr);

        return result ? '1' : '0';
    }
}