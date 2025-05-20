class TrieNode
{
    TrieNode[] children = new TrieNode[2];
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        
        int maxNum = -1;
        for (int num: nums)
            maxNum = Math.max(maxNum, num);

        int len = Integer.toBinaryString(maxNum).length();

        // insert all nums to bitwise tree
        // compute max possible XOR on the fly for the current number and other numbers already in the trie
        TrieNode root = new TrieNode();
        int maxXor = 0;
        for (int num: nums)
        {
            TrieNode curr = root;
            TrieNode xorNode = root;
            int currXor = 0;

            for (int i=len - 1; i>=0; i--)
            {
                int bit = (num >> i) & 1;

                if (curr.children[bit] == null)
                    curr.children[bit] = new TrieNode();

                curr = curr.children[bit];

                int invbit = bit ^ 1;
                
                // take node with opposite bit when possible
                if (xorNode.children[invbit] != null)
                {
                    xorNode = xorNode.children[invbit];
                    currXor |= (1 << i);
                } else {
                    xorNode = xorNode.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;






    }
}