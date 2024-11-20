class MyCalendarTwo {

    Map<Integer, Integer> startsEnds = new TreeMap<>();
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        startsEnds.put(startTime, startsEnds.getOrDefault(startTime, 0) + 1);
        startsEnds.put(endTime, startsEnds.getOrDefault(endTime, 0) -1);

        int runningSum = 0;
        for (int value: startsEnds.values())
        {
            runningSum += value;
            if (runningSum > 2) {
                startsEnds.put(startTime, startsEnds.get(startTime) - 1);
                startsEnds.put(endTime, startsEnds.get(endTime) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */