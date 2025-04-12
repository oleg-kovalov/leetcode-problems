class MyCalendar {

    ArrayList<int[]> events = new ArrayList<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        // check intersecrion with earlier event
        int leftId = -1;
        int lo = 0;
        int hi = events.size() - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (events.get(mid)[0] <= startTime)
            {
                leftId = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (leftId != -1 && startTime < events.get(leftId)[1]) return false;

        int rightId = -1;
        lo = 0;
        hi = events.size() - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (events.get(mid)[0] >= startTime)
            {
                rightId = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (rightId != -1 && endTime > events.get(rightId)[0]) return false;

        events.add(leftId+1, new int[] {startTime, endTime});
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */