class MyCalendar {

    ArrayList<int[]> events = new ArrayList<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        // intersection would be if condition holds
        // existingStart < newEnd && newStart < existingEnd
        int leftId = -1;
        int lo = 0;
        int hi = events.size() - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (events.get(mid)[0] < endTime)
            {
                leftId = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (leftId != -1 && startTime < events.get(leftId)[1]) return false;

        events.add(leftId+1, new int[] {startTime, endTime});
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */