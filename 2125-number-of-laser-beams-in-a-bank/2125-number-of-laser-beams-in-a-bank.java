class Solution {
    public int numberOfBeams(String[] bank) {
        int completeLasers = 0;
        int[] laserStartCount = new int[]{-1, -1};
        for (int i = 0; i < bank.length; i++) {
            String row = bank[i];
//            int lasersInRow = Integer.bitCount(Integer.parseInt(row, 2));
            int lasersInRow = 0;
            for (int c=0; c<row.length(); c++)
            {
                if (row.charAt(c) - '0' != 0) lasersInRow++;
            }
            if (lasersInRow != 0) {
                if (i != laserStartCount[0] && laserStartCount[0] != -1) {
                    completeLasers += lasersInRow * laserStartCount[1];
                }

                laserStartCount[0] = i;
                laserStartCount[1] = lasersInRow;
            }
        }

        return completeLasers;
    }
}