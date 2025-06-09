class Solution {
    int[] prefix;
    int totalSum = 0;

    public Solution(int[] w) {
        prefix = new int[w.length];

        int runningSum = 0;
        for (int i=0; i<w.length; i++)
        {
            runningSum += w[i];
            prefix[i] = runningSum;
        }

        totalSum = runningSum;
    }
    
    public int pickIndex() {
        double num = totalSum * Math.random();

        int upperBoundary = 0;
        while (num > prefix[upperBoundary])
        {
            upperBoundary += 1;
        }

        return upperBoundary;
    }
}


// Brute force
//
// class Solution {
//     List<Integer> stretched = new ArrayList<>();
//     Random random = new Random();
//     int totalSum = 0;

//     public Solution(int[] w) {
//         for (int i=0; i<w.length; i++)
//         {
//             int weight = w[i];
//             for (int j=0; j<weight; j++)
//             {
//                 stretched.add(i);
//             }
//             totalSum += weight;
//         }
//     }
    
//     public int pickIndex() {
//         if (stretched.size() == 1) return stretched.get(0);

//         // int idx = random.nextInt(stretched.size() - 1);
//         int idx = (int) (totalSum * Math.random());
//         return stretched.get(idx);
//     }
// }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */