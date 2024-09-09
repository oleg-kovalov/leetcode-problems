/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int low = 0;
        int high = cols - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean hasOne = false;

            for (int row = 0; row < rows; row++) {
                int current = binaryMatrix.get(row, mid);
                hasOne = hasOne || (current == 1);
            }
            if (!hasOne) {
                // all 0
                low = mid + 1;
            } else {
                // at least one 1
                high = mid -1;
            }

        }
        
        int result = high+1;
        return (result <= cols -1) ? result : -1;

    }
}