class Solution {
    public int[][] imageSmoother(int[][] img) {

        for (int i=0; i<img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int sum = 0;
                int divisor = 0;

                for (int si = i - 1; si < i + 2; si++) {
                    for (int sj = j - 1; sj < j + 2; sj++) {
                        if (0 <= si && si < img.length
                            && 0 <= sj && sj < img[i].length)
                        {
                            sum += img[si][sj] < 256 ? img[si][sj] : img[si][sj] % 256;
                            divisor++;
                        }
                    }
                }

                img[i][j] = 256 * (sum / divisor) + img[i][j];

            }
        }

        for (int i=0; i<img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                img[i][j] = (img[i][j] - img[i][j] % 256) / 256;
            }
        }

        // for (int[] row : img) {
        //     System.out.println(Arrays.toString(row));
        // }

        return img;

    }
}