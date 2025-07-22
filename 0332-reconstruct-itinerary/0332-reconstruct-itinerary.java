class Solution {
    Map<String, List<String>> adjMap = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        Collections.sort(tickets, (a,b) -> !a.get(0).equals(b.get(0)) 
            ? a.get(0).compareTo(b.get(0))
            : a.get(1).compareTo(b.get(1)));

        for (int i=0; i<tickets.size(); i++)
        {
            List<String> ticket = tickets.get(i);
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adjMap.putIfAbsent(src, new ArrayList<>());
            adjMap.get(src).add(dest);
        }

        eulerianPath("JFK");
        
        return result;
    }

    private void eulerianPath(String city) 
    { 
        List<String> dests = adjMap.getOrDefault(city, Collections.emptyList());

        while (dests.size() > 0)
        {
            String dest = dests.get(0);
            dests.remove(0);
            eulerianPath(dest);
        }

        result.addFirst(city);
    }
}