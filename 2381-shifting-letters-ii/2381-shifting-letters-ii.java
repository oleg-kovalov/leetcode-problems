class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] combined = new int[s.length()];

        for (int[] shift : shifts)
        {
            int direction = shift[2] == 1 ? 1 : -1;
            combined[shift[0]] += direction;
            if (shift[1] + 1 < s.length()) combined[shift[1] + 1] -= direction;
        }

        StringBuilder result = new StringBuilder();
        int runningSum = 0;
        for (int i=0; i<s.length(); i++)
        {
            runningSum += combined[i];
            // System.out.println(runningSum);
            int shift = (s.charAt(i) - 'a' + 26 + runningSum % 26) % 26;
            System.out.println(shift);
            result.append((char)('a' + shift));
        }

        return result.toString();


    }
}