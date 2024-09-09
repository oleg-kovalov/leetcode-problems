class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {

        boolean black1 =
            (coordinate1.charAt(0) - 'a' + 1) % 2 == coordinate1.charAt(1) % 2;

        boolean black2 =
            (coordinate2.charAt(0) - 'a' + 1) % 2 == coordinate2.charAt(1) % 2;

        return black1 == black2;
    }
}