class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int distX = Math.abs(fx - sx);
        int distY = Math.abs(fy - sy);

        if (distX == 0 && distY == 0 && t == 1)
        {
            return false;
        }

        return t >= Math.max(distX, distY);
    }
}