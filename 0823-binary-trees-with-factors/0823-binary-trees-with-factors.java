class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr); //sort ASC

        HashMap<Integer, Long> rootToTreeCount = new HashMap<>();
        for (int root: arr)
        {
            rootToTreeCount.put(root, 1L);
        }

        for (int root : arr)
        {
            for (int factor : arr)
            {
                if (factor >= root)
                {
                    break;
                }
                
                if (root % factor == 0) //left child
                {
                    int rightChild = root / factor;
                    if (rootToTreeCount.containsKey(rightChild))
                    {
                        long treeNum = rootToTreeCount.get(root) 
                            + rootToTreeCount.get(factor) * rootToTreeCount.get(rightChild);
                        rootToTreeCount.put(root, treeNum);
                    }
                }
            }
        }
        
        long totalTrees = 0L;
        for (Integer root : rootToTreeCount.keySet()) {
            totalTrees = (totalTrees + rootToTreeCount.get(root)) % 1_000_000_007;
        }

        return (int) totalTrees;
    }
}