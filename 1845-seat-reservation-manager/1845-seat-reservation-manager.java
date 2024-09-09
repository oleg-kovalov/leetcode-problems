    class SeatManager {

        PriorityQueue<Integer> unreservedSeats;
        int reservedMarker;

        public SeatManager(int n) {
            unreservedSeats = new PriorityQueue<>(); //ASC
            reservedMarker = 0;
        }

        public int reserve() {
            if (unreservedSeats.size() > 0)
            {
                return unreservedSeats.poll();
            }

            reservedMarker++;
            return reservedMarker;
        }

        public void unreserve(int seatNumber) {
            unreservedSeats.offer(seatNumber);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */