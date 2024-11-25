class Solution {

    class State
    {
        final int moves;
        final StringBuilder order;

        public State (int moves, StringBuilder order) { this.moves = moves; this.order = order;}
    }

    HashSet<String> seen = new HashSet<>();

    public int slidingPuzzle(int[][] board) {



        StringBuilder startOrder = new StringBuilder();
        for (int row=0; row < board.length; row++)
        {
            for (int col=0; col < board[0].length; col++)
            {
                startOrder.append(board[row][col]);
            }
        }

        PriorityQueue<State> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.moves, b.moves));
        minHeap.offer(new State(0, startOrder));
        seen.add(startOrder.toString());

        while (minHeap.size() > 0)
        {
            State state = minHeap.poll();
            // System.out.println(state.moves + " - " + state.order.toString());

            if ("123450".equals(state.order.toString())) return state.moves;
            if (state.moves > 20) return -1; //what is max moves?

            int zero = -1;
            for (int i=0; i<state.order.length(); i++)
            {
                if (state.order.charAt(i) == '0') {
                    zero = i;
                    break;
                }
            }

            // left
            if (zero != 0 && zero != 3)
            {
                StringBuilder leftState = new StringBuilder(state.order.toString());
                leftState.setCharAt(zero, leftState.charAt(zero - 1));
                leftState.setCharAt(zero - 1, '0');
                if (!seen.contains(leftState.toString()))
                {
                    minHeap.offer(new State(state.moves + 1, leftState));
                    seen.add(leftState.toString());
                }
            }
            // right
            if (zero != 2 && zero != 5)
            {
                StringBuilder rightState = new StringBuilder(state.order.toString());
                rightState.setCharAt(zero, rightState.charAt(zero + 1));
                rightState.setCharAt(zero + 1, '0');
                if (!seen.contains(rightState.toString()))
                {
                    minHeap.offer(new State(state.moves + 1, rightState));
                    seen.add(rightState.toString());
                }
            }
            // up
            if (zero - 3 >= 0)
            {
                StringBuilder upState = new StringBuilder(state.order.toString());
                upState.setCharAt(zero, upState.charAt(zero - 3));
                upState.setCharAt(zero - 3, '0');
                if (!seen.contains(upState.toString()))
                {
                    minHeap.offer(new State(state.moves + 1, upState));
                    seen.add(upState.toString());
                }
            }
            //down
            if (zero + 3 < 6)
            {
                StringBuilder downState = new StringBuilder(state.order.toString());
                downState.setCharAt(zero, downState.charAt(zero + 3));
                downState.setCharAt(zero + 3, '0');
                if (!seen.contains(downState.toString()))
                {
                    minHeap.offer(new State(state.moves + 1, downState));
                    seen.add(downState.toString());
                }
            }


        }

        return -1;

    }
}