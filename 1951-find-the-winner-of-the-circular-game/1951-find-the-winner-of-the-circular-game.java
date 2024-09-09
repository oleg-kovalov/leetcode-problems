class Solution {
    public int findTheWinner(int n, int k) {
        final Set<Integer> players = new HashSet<>();

        Player first = new Player(1);
        Player current = first;
        players.add(current.val);

        for (int i=2; i<=n; i++)
        {
            Player next = new Player(i);
            players.add(next.val);

            current.next = next;
            next.prev = current;

            current = next;
        }

        current.next = first;
        first.prev = current;

        current = first;
        while (players.size() > 1)
        {
            for (int i=0; i<k-1; i++)
            {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;

            players.remove(current.val);
            current = current.next;
        }

        return players.iterator().next();
    }

    private class Player {
        private int val;
        private Player next;
        private Player prev;

        Player(int val)
        {
            this.val = val;
        }

        public void setNext(Player next)
        {
            this.next = next;
        }

        public void setPrev(Player prev)
        {
            this.prev = prev;
        }
    }
}