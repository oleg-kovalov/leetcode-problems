class Solution {
    public String destCity(List<List<String>> paths) {

        HashSet<String> sources = new HashSet<>();

        for (List<String> path : paths) {
            sources.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (! sources.contains(path.get(1)))
            {
                return path.get(1);
            }
        }

        return "empty";
    }
}