class Solution {
    public int kthGrammar(int n, int k) {
        return iterateRec(n, k, 0);
    }

    private int iterateRec (int n, int k, int root)
    {
        if (n == 1) return root;

        int lastRowElements = (int)Math.pow(2, n-1);

        if (k > lastRowElements/2)
        {
            int nextRoot = root == 0 ? 1 : 0;
            return iterateRec(n-1, k - lastRowElements/2, nextRoot);
        } else {
            int nextRoot = root;
            return iterateRec(n-1, k, nextRoot);
        }

    }
}