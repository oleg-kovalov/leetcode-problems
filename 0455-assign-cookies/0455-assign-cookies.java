class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int content = 0;
        int si=0;

        for (int gi=0; gi<g.length; gi++)
        {
            while (si < s.length && s[si] < g[gi])
            {
                si++;
            }
            if (si == s.length)
            {
                break;
            }
            content++;
            si++;
        }

        return content;
    }
}