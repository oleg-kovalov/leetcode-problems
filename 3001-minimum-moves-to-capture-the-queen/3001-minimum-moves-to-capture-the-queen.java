class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {


        // it's possible to capture queen in 1 move if
        // it's on same diagonal with bishop
        // or same line with rook
        // and there is no second figure on the way

        //same vertical
        if (a == e) {
            if (a == c && d < Math.max(b, f) && d > Math.min(b, f)) {
                // bishop on the way
                return 2;
            } else {
                return 1;
            }
        }


        // same horizontal
        if (b == f) {
            if (b == d && c < Math.max(a, e) && c > Math.min(a, e)) {
                // bishop on the way
                return 2;
            } else {
                return 1;
            }
        }

        // same right diagonal
        if (c - e == f - d) {
            if (c - a == b - d && a < Math.max(c, e) && a > Math.min(c, e)) {
                // rook on the way
                return 2;
            } else {
                return 1;
            }
        }

        //same left diagonal
        if (c - e == d - f) {
            if (c - a == d - b && a < Math.max(c, e) && a > Math.min(c, e)) {
                // rook on the way
                return 2;
            } else {
                return 1;
            }
        }


        return 2;

    }
}