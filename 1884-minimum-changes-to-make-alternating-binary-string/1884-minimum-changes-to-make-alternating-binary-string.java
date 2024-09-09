class Solution {
    public int minOperations(String s) {
        int diff1 = 0;
        int diff2 = 0;
        boolean flag = false;
        for (int i=0; i<s.length(); i++)
        {
            if (s.charAt(i) != (flag?'0':'1'))
            {
                diff1++;
            }
            if (s.charAt(i) != (flag?'1':'0'))
            {
                diff2++;
            }
            flag = !flag;
        }

        // System.out.println(Math.min(diff1, diff2));

        return Math.min(diff1, diff2);
    }
}