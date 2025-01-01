class Solution {
    public String stringShift(String s, int[][] shift) {
        int resShift = 0;
        for (int[] move: shift)
        {
            resShift += (move[0] == 0 ? -1 : 1) * move[1];
        }
        resShift %= s.length();
        resShift = (resShift >=0 ? resShift : resShift + s.length());

        StringBuilder res = new StringBuilder(s);
        for (int i=0; i<s.length(); i++)
        {
            int idx = (i + resShift) % s.length(); 
            res.setCharAt(idx, s.charAt(i));
        }

        return res.toString();
    }
}