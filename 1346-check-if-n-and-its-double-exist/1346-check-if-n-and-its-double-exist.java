class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> pair = new HashSet<>();
        for (int num: arr)
        {
            if (pair.contains(num)) return true;

            if (num == 0) {
                pair.add(0);
            } else {
                pair.add(num * 2);
                if (num % 2 == 0)
                {
                    pair.add(num / 2);
                }                
            }
        }

        return false;
    }
}