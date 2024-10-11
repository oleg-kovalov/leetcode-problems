class Solution {

    class Event 
    {
        final int time;
        final int guest;
        final boolean leave;

        public Event(int time, int guest, boolean leave)
        {
            this.time = time;
            this.guest = guest;
            this.leave = leave;
        }

        public int getTime() { return time; }
        public int getGuest() { return guest; }
        public boolean getLeave() { return leave; }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Event> timeline = new PriorityQueue<Event>((Event a, Event b) -> {
            if (a.getTime() != b.getTime())
            {
                return a.getTime() - b.getTime();
            } else {
                 if (a.getLeave()) 
                 {
                    return -1;
                 } else {
                    return 1;
                 }
            }
        });

        for (int i=0; i<times.length; i++)
        {
            timeline.offer(new Event(times[i][0], i, false));
            timeline.offer(new Event(times[i][1], i, true));
        }

        HashMap<Integer, Integer> guestToTable = new HashMap<>();

        PriorityQueue<Integer> tables = new PriorityQueue<>();
        for (int i=0; i<times.length; i++)
        {
            tables.offer(i);
        }

        while (timeline.size() > 0)
        {
            Event event = timeline.poll();
            if (event.getGuest() == targetFriend)
            {
                return tables.poll();
            } else {
                if (event.getLeave())
                {
                    tables.offer(guestToTable.get(event.getGuest()));
                } else {
                    guestToTable.put(event.getGuest(), tables.poll());
                }
            }
        }

        return -1;
    }

    




}