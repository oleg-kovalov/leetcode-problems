class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) { //[1,10][3,3]  , [3,3,2]

        int[] starts = new int[flowers.length];
        int[] ends = new int[flowers.length];

        for (int i=0; i<flowers.length; i++)
        {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        

        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] result = new int[people.length];

        for (int i=0; i<result.length; i++)
        {
            int startCount = findEventsBefore(starts, people[i]);
            int endCount = findEventsBefore(ends, people[i] - 1);
            System.out.println(startCount + " "+ endCount);
            result[i] = startCount - endCount;            
        }

        return result;
    }

    private int findEventsBefore(int[] starts, int time)
    {
        // find smallest index that has value larger than time
        // return count of elems before that index 
        if (time <= 0) return 0;

        int lo=0; 
        int hi = starts.length - 1;
        int result = starts.length;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (starts[mid] > time)
            {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (result == -1) return 0;

        return result;
    }
}