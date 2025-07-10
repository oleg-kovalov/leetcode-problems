class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        int maxEnd = 0;
        for (int[] interval: intervals) 
            maxEnd = Math.max(maxEnd, interval[1]);

        int[] line = new int[maxEnd + 1];
        for (int[] interval: intervals)
        {
            line[interval[0]] += 1;
            line[interval[1]] -= 1;
        }
        
        int count = 0;
        for (int i=0; i<line.length; i++)
        {
            count += line[i];
            if (count > 1) return false;
        } 

        return true;

    }
}