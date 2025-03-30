class Solution {
    public int[] getOrder(int[][] t) { //[1,1],[100,1]
                
        int[][] tasks = new int[t.length][3];
        for (int i=0; i<t.length; i++)
        {
            tasks[i] = new int[]{ t[i][0],t[i][1],i};
        }

        Arrays.sort(tasks, (a,b) -> Integer.compare(a[0], b[0]));
        //[1,1,0],[100,1,0]
                                            //    ^
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->
            a[1] != b[1] ? Integer.compare(a[1],b[1]) : Integer.compare(a[2], b[2]));
        //[[1,1,0]]
        
        List<Integer> result = new ArrayList<>(); // 0
        int time = 1; //4
        int idx = 0; //1
        while (idx < tasks.length || minHeap.size() > 0)
        {
            while(idx < tasks.length && tasks[idx][0] <= time)
            {
                minHeap.offer(tasks[idx]);
                idx++;
            }

            if (minHeap.size() > 0)
            {
                int[] task = minHeap.poll();
                result.add(task[2]);
                time += task[1];
            } else {
                if (idx < tasks.length) time = tasks[idx][0];
            }
        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}