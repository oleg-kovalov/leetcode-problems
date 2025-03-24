class Solution {
//[[]]
//[[1]]
//[[2,1], [1,2]]
//[[3,2,1],[2,3,1],[2,1,3],  [3,1,2],[1,3,2],[1,2,3]]


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> totalLists = new ArrayList<>();
        totalLists.add(new ArrayList<>());

        for (int i=0; i<nums.length; i++)
        {
            List<List<Integer>> currLists = new ArrayList<>();
            int num = nums[i];
            for (List<Integer> list: totalLists)
            {
                for (int j=0; j<list.size() + 1; j++)
                {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j, num);
                    currLists.add(newList); 
                }
            }
            totalLists = currLists; 
        }

        return totalLists;
    }

}
