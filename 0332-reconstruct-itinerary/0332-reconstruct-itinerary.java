class Solution {
    int n;
    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();

        Collections.sort(tickets, (a,b) -> !a.get(0).equals(b.get(0)) 
            ? a.get(0).compareTo(b.get(0))
            : a.get(1).compareTo(b.get(1)));

        Map<String, List<String>> adjMap = new HashMap<>();

        for (int i=0; i<tickets.size(); i++)
        {
            List<String> ticket = tickets.get(i);
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adjMap.putIfAbsent(src, new ArrayList<>());
            adjMap.get(src).add(dest);
        }

        List<String> path = new ArrayList<>();
        // path.add("JFK");
        backtrack("JFK", path, adjMap);
        
        Collections.reverse(path);
        return path;
    }

    private void backtrack(String city, List<String> path, Map<String, List<String>> adjMap) 
    { 
        List<String> dests = adjMap.getOrDefault(city, Collections.emptyList());

        while (dests.size() > 0)
        {
            String dest = dests.get(0);
            dests.remove(0);
            backtrack(dest, path, adjMap);
        }

        path.add(city);
    }
}